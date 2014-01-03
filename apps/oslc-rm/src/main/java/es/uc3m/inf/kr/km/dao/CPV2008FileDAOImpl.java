package es.uc3m.inf.kr.km.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.DC;

import es.uc3m.inf.kr.common.loader.JenaRDFModelWrapper;
import es.uc3m.inf.kr.common.loader.KRModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.FilesResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.rm.SKOS;
import es.uc3m.inf.kr.rm.to.Person;
import es.uc3m.inf.kr.rm.to.VocabularyTO;

public class CPV2008FileDAOImpl implements VocabularyDAO{

	Model model;
	String lang =  "en";
	List<VocabularyTO> vocabularyTOs;
	
	public CPV2008FileDAOImpl(){
		ResourceLoader loader = new FilesResourceLoader(new String[]{"cpv/cpv-2008.ttl"});
		JenaRDFModelWrapper rdfModel = new JenaRDFModelWrapper(loader,"TURTLE");
		this.model = (Model) rdfModel.getModel();		
		try {
			this.vocabularyTOs = loadAll();
		} catch (URISyntaxException e) {
			this.vocabularyTOs = new LinkedList<VocabularyTO>();
		}
	}

	public CPV2008FileDAOImpl(KRModelWrapper wrapper){		
		this.model = (Model) wrapper.getModel();		
	}

	public CPV2008FileDAOImpl(KRModelWrapper wrapper, String lang){		
		this.model = (Model) wrapper.getModel();	
		this.lang = lang;
	}


	
	public List<VocabularyTO> getTerms() throws URISyntaxException {
		return this.vocabularyTOs;
	}

	private List<VocabularyTO> loadAll() throws URISyntaxException {
		ResIterator it = model.listResourcesWithProperty(
				model.getProperty(SKOS.IN_SCHEME));
		List<VocabularyTO> vocabularyTOs = new LinkedList<VocabularyTO>();

		//FIXME: Hardcoded contributor
		Person contributor = new Person();
		contributor.setName("Jose");
		contributor.setMbox("mailto:josemaria.alvarez@uc3m.es");
		contributor.setUri(new URI("http://josemalvarez.es/foaf.rdf#me"));

		while(it.hasNext()){
			Resource r = it.next();
			VocabularyTO vocabularyElementTO = new VocabularyTO();
			vocabularyElementTO.addContributor(contributor);
			vocabularyElementTO.setAbout(new URI(r.getURI()));
			vocabularyElementTO.setNotation(r.getProperty(DC.identifier).getString());
			vocabularyElementTO.setSubject(r.getProperty(DC.subject).getString());
			vocabularyElementTO.setInScheme(model.getProperty(SKOS.IN_SCHEME).getURI());
			vocabularyElementTO.setCreationDate(GregorianCalendar.getInstance().getTime());
			vocabularyElementTO.setModifiedDate(GregorianCalendar.getInstance().getTime());
			//pscTO.setType(r.getProperty(RDF.type).getResource().getURI());
			StmtIterator iter = model.listStatements(
				    new SimpleSelector(r, model.getProperty(SKOS.PREF_LABEL), (RDFNode) null) {
				        public boolean selects(Statement s)
				            {return s.getLiteral().getLanguage().equalsIgnoreCase(lang);}
				    });	
			while(iter.hasNext()){
				vocabularyElementTO.setPrefLabel(iter.next().getString());
			}
			vocabularyTOs.add(vocabularyElementTO);
		}
		return vocabularyTOs;
	}

	public VocabularyTO getVocabularyElement(String conceptId) {
		boolean found = Boolean.FALSE;
		VocabularyTO elementToReturn = null;
		for(int i = 0; i<this.vocabularyTOs.size() && !found;i++){
			VocabularyTO element = this.vocabularyTOs.get(i);
			if (element.getNotation().equals(conceptId)){
				found = Boolean.TRUE;
				elementToReturn = element;
			}
		}
		return elementToReturn;
	}



}