package es.uc3m.inf.kr.km.appserv;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;












import java.util.ResourceBundle;
import java.util.Set;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.loader.JenaOWLModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.FilesResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.URLFilesResourceLoader;
import es.uc3m.inf.kr.common.to.ModelTO;
import es.uc3m.inf.kr.common.to.OntologyDataTO;
import es.uc3m.inf.kr.common.to.ResourceTO;
import es.uc3m.inf.kr.common.utils.SparQLUtils;
import es.uc3m.inf.kr.km.dao.KnowledgeManagementDAO;
import es.uc3m.inf.kr.pscs.to.GraphTO;

public class KnowledgeManagementFacade{


	private OntModel model;
	private OntModel defaultModel; //It is static only in construction
	public static Set filteredNamespaces = new HashSet<String>();

	static{
		 ResourceBundle namespaces = ResourceBundle.getBundle(KnowledgeManagementFacade.class.getName().toString());
		 Enumeration<String> keys = namespaces.getKeys();
         while(keys.hasMoreElements()){
                 String key = keys.nextElement();
                 filteredNamespaces.add(namespaces.getObject(key));
         }
	}
	
	public KnowledgeManagementFacade(){
		this.defaultModel = createDefaultModel();
		this.model = ModelFactory.createOntologyModel();
		updateModel();
	}



	private void updateModel() {
		this.model.add(this.defaultModel);
	}

	private OntModel createDefaultModel() {
		ResourceLoader loader = new FilesResourceLoader(new String[]{
				//  "data/car-example-skos.ttl"

		});
		JenaOWLModelWrapper wrapper = new JenaOWLModelWrapper(loader);
		return (OntModel)wrapper.getModel();
	}

	public KnowledgeManagementFacade(KnowledgeManagementDAO dao){
		this.defaultModel = createDefaultModel();
		this.model = (OntModel) dao.getModel().getModel();
		updateModel();
	}


	//Method to add: users, organizations and any sort of RDF resource
	public boolean loadResource(ResourceTO resource){
		ResourceLoader loader = new URLFilesResourceLoader(new String[]{resource.getAbout().toASCIIString()});
		JenaOWLModelWrapper wrapper = new JenaOWLModelWrapper(loader);
		this.model.add((OntModel)wrapper.getModel());
		return Boolean.TRUE;
	}



	//Model management
	public boolean addOntology(OntologyDataTO ontology){
		ResourceLoader loader = new URLFilesResourceLoader(new String[]{ontology.getUri()});
		JenaOWLModelWrapper wrapper = new JenaOWLModelWrapper(loader,ontology.getFormat());
		this.model.add((OntModel)wrapper.getModel());
		return Boolean.TRUE;
	}

	public List<OntologyDataTO> listOntologies(){
		List<OntologyDataTO> ontologies = new LinkedList<OntologyDataTO>();             
		ExtendedIterator<Ontology> it = this.model.listOntologies();
		while(it.hasNext()){
			Ontology onto = it.next();
			OntologyDataTO ontology = new OntologyDataTO();
			ontology.setUri(onto.getURI());
			ontology.setLabel(onto.getLabel("en"));
			ontology.setComment(onto.getComment("en"));
			ontologies.add(ontology);
		}
		return ontologies;
	}

	public OntologyDataTO getOntology(OntologyDataTO ontology){
		try {
			Ontology onto = this.model.getOntology(ontology.getUri());
			StringWriter writer = new StringWriter();
			onto.getOntModel().write(writer);
			writer.close();
			OntologyDataTO result = new OntologyDataTO();
			result.setUri(onto.getURI());
			result.setContent(writer.toString());
			return result;
		} catch (IOException e) {
			throw new KRModelException(e);
		}       
	}

	public ModelTO getModel(){
		StringWriter writer = new StringWriter();
		this.model.write(writer);
		ModelTO result = new ModelTO();
		result.setContent(writer.toString());
		return result;
	}

	public boolean newModel(){
		this.model = null;
		this.model = ModelFactory.createOntologyModel();
		updateModel();
		return Boolean.TRUE;
	}


	public boolean newModel(OntologyDataTO ontology){
		ResourceLoader loader = new URLFilesResourceLoader(new String[]{ontology.getUri()});
		JenaOWLModelWrapper wrapper = new JenaOWLModelWrapper(loader,ontology.getFormat());
		this.model = null;
		this.model = (OntModel) wrapper.getModel();
		updateModel();
		return Boolean.TRUE;
	}
	//Listing methods

	public List<ResourceTO> listClasses(){
		return createListOfResources(this.model.listClasses());
	}

	public List<ResourceTO> listProperties(){
		List<ResourceTO> properties = createListOfResources(this.model.listAnnotationProperties());
		properties.addAll(createListOfResources(this.model.listDatatypeProperties()));
		properties.addAll(createListOfResources(this.model.listObjectProperties()));
		properties.addAll(createListOfResources(this.model.listAllOntProperties()));
		return properties; //FIXME: only ont properties
	}

	public List<ResourceTO> listInstances(){
		return createListOfResources(this.model.listIndividuals());
	}

	public List<ResourceTO> listInstancesOf(ResourceTO clazz){
		return createListOfResources(this.model.getOntClass(clazz.getUri()).listInstances(true));
	}

	public List<ResourceTO> listPropertiesOf(ResourceTO clazz){
		if(this.model.getOntClass(clazz.getUri())!=null){
			return createListOfResources(this.model.getOntClass(clazz.getUri()).listDeclaredProperties(true));	
		}else if(this.model.getIndividual(clazz.getUri())!=null){
			return createListOfResources(this.model.getIndividual(clazz.getUri()).listProperties());
		}
			
		return Collections.emptyList();
	}


	private List<ResourceTO> createListOfResources(StmtIterator it) {
		List<ResourceTO> resources = new LinkedList<ResourceTO>();              
		while(it.hasNext()){
			ResourceTO createResourceTO = createResourceTO(it.next());
			if(createResourceTO!=null)
				resources.add(createResourceTO);
		}
		return resources;
	}



	private ResourceTO createResourceTO(Statement next) {
		ResourceTO resource = new ResourceTO(next.getPredicate().getURI());
		return resource;
	}



	public boolean addClass(ResourceTO clazz, ResourceTO parent){
		OntClass newClass = this.model.createClass(clazz.getUri());
		newClass.setLabel(clazz.getLabel(), "en");
		newClass.setComment(clazz.getDescription(), "en");
		newClass.addSuperClass(this.model.getOntClass(parent.getUri()));
		return Boolean.TRUE;
	}


	public boolean addInstance(ResourceTO instance, ResourceTO clazz){
		Individual newInstance = 
				this.model.createIndividual(instance.getUri(), this.model.getOntClass(clazz.getUri()));
		newInstance.setLabel(clazz.getLabel(), "en");
		newInstance.setComment(clazz.getDescription(), "en");
		return Boolean.TRUE;
	}



	public boolean addProperty(ResourceTO property, ResourceTO resource1, ResourceTO resource2){
		OntResource r1 = this.model.getOntResource(resource1.getUri());
		OntResource r2 = this.model.getOntResource(resource2.getUri());
		//FIXME: check if exists
		OntProperty prop = this.model.getOntProperty(property.getUri());
		if(prop == null){
			prop = this.model.createOntProperty(property.getUri());
		}
		this.model.add(r1, prop, r2);
		return Boolean.TRUE;
	}



	public boolean createProperty(ResourceTO property){
		OntProperty prop = this.model.getOntProperty(property.getUri());
		if(prop == null){
			prop = this.model.createOntProperty(property.getUri());
		}
		return Boolean.TRUE;
	}


	public ResourceTO getClass(ResourceTO clazz){
		return createResourceTO(this.model.getOntResource(clazz.getUri()));
	}


	public boolean removeClass(ResourceTO clazz){
		//this.model.getOntClass(clazz.getUri()).getOntModel().write(System.out);
		//this.model.remove(this.model.getOntClass(clazz.getUri()).getOntModel());
		return Boolean.FALSE;
	}


	public boolean removeInstance(ResourceTO clazz){
		return Boolean.FALSE;
	}


	public boolean removeProperty(ResourceTO clazz){
		return Boolean.FALSE;
	}


	public boolean removeTag(ResourceTO clazz){
		return Boolean.FALSE;
	}

	public ResourceTO getProperty(ResourceTO property){
		return createResourceTO(this.model.getOntResource(property.getUri()));
	}


	public ResourceTO getInstance(ResourceTO instance){
		return createResourceTO(this.model.getOntResource(instance.getUri()));
	}
	//Helper methods
	private static List<ResourceTO> createListOfResources(ExtendedIterator<? extends OntResource> it){
		List<ResourceTO> resources = new LinkedList<ResourceTO>();              
		while(it.hasNext()){
			ResourceTO createResourceTO = createResourceTO(it.next());
			if(createResourceTO!=null)
				resources.add(createResourceTO);
		}
		return resources;
	}
	private static ResourceTO createResourceTO(OntResource ontResource){
		if(ontResource != null && !filteredNamespaces.contains(ontResource.getNameSpace())){
			ResourceTO resource = new ResourceTO();
			resource.setUri(ontResource.getURI());
			resource.setLabel(ontResource.getLabel("en")==null?"":ontResource.getLabel("en"));
			resource.setDescription(ontResource.getComment("en")==null?"":ontResource.getComment("en"));
			resource.setType(ontResource.isResource()?"Resource":"Literal");
			return resource;

		}
		return null;
	}



	public ResourceTO valueOf(ResourceTO resource, ResourceTO property) {
		OntResource ontResource = this.model.getOntResource(resource.getUri());
		Property ontProperty = this.model.getProperty(property.getUri());
		if(ontResource!=null && ontProperty != null){
			ResourceTO resourceTO = new ResourceTO(resource.getUri());//FIXME:
			resourceTO.setLabel(ontResource.getProperty(ontProperty).getString());
			resourceTO.setDescription(property.getUri());
			return resourceTO;
		}
		return null;
				
	}



	public GraphTO createGraph(String uri) {
		String queryStr = "DESCRIBE <"+uri+">";
		Model result = SparQLUtils.executeDescribe(this.model.getBaseModel(), queryStr);
		Resource resource = result.getResource(uri);
		StmtIterator iter = resource.listProperties();
		GraphTO graph = new GraphTO();
		graph.setName(resource.getURI());
		while(iter.hasNext()){
			Statement stmt = iter.nextStatement();
			GraphTO child = new GraphTO();
			child.setLabel(stmt.getPredicate().getURI());
			RDFNode object = stmt.getObject();
			if(object.isLiteral()){
				child.setName(object.asLiteral().getString()+(!object.asLiteral().getLanguage().equalsIgnoreCase("")?"@"+object.asLiteral().getLanguage():""));
			}else if (object.isResource()){
				child.setName(stmt.getPredicate().getURI());
				child.getChildren().add(this.createGraph(object.asResource().getURI()));
			}else if (object.isURIResource()){
				
			}
			graph.getChildren().add(child);
		}
		return graph;
	}
}