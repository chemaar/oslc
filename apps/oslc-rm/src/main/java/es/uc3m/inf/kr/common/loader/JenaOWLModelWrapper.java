package es.uc3m.inf.kr.common.loader;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.rulesys.OWLMicroReasoner;
import com.hp.hpl.jena.reasoner.rulesys.OWLMicroReasonerFactory;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;

/**
 *
 * This class implements the interface MoldeasModelWrapper loading (without a reasoner) the data from a file and
 * returning a Jena OntoModel.
 *
 */
public class JenaOWLModelWrapper implements KRModelWrapper{
  

    private static final Logger logger = Logger.getLogger(JenaOWLModelWrapper.class);

    private ResourceLoader resourceLoader;
    private OntModel jenaOWLModel;
	private String format = "";
    
    public JenaOWLModelWrapper(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.format = resourceLoader.getFormat();
    }

    public JenaOWLModelWrapper(ResourceLoader resourceLoader, String format) {
        this.resourceLoader = resourceLoader;
        this.format = format;
    }
    
    private Model getJenaOWLModel() {   // NOTE: !synchronized
        if (loadJenaOWLModel(this.resourceLoader)) {  
            logger.debug("Loaded Jena Owl model");
        }            
        return jenaOWLModel;
    }
    
    
    private synchronized boolean loadJenaOWLModel(ResourceLoader rdfSource)  {
        if(this.jenaOWLModel == null){
            logger.debug("Jena model for is null: creating new Jena Model");
            //Create JenaModel               
            jenaOWLModel = createJenaOWLModel(rdfSource);
            return true;
        } else {
            return false;
        }        
    }
    
    /**
     * Helper Method
     * @return
     * @throws ResourceNotFoundException
     */
    private OntModel createJenaOWLModel(ResourceLoader owlSource) throws ResourceNotFoundException {
        KnowledgeResourcesTO[] owlsources = null;
        //Do not use reasoner to load ontologies
        OntDocumentManager dm = OntDocumentManager.getInstance();
        dm.setProcessImports(false);
        OntModelSpec spec = new OntModelSpec( OntModelSpec.OWL_MEM);
        spec.setDocumentManager(dm);
        spec.setReasoner(new OWLMicroReasoner(OWLMicroReasonerFactory.theInstance()));
        OntModel ontModel = ModelFactory.createOntologyModel(spec, null );
        owlsources = owlSource.getKnowledgeResources();
        logger.debug("Loading " + owlsources.length  +" resources into the model");
        for ( int i = 0; i< owlsources.length ; i++ ) {
            final InputStream is = owlsources[i].getKnowledgeSourceData();        
            logger.debug("Loading model "+owlsources[i].getKnowledgeSourcePk()+" "+this.format);
            ontModel.read(is,"", this.format);   
            try {
                is.close();
            } catch (IOException e) {
                throw new KRModelException(e, "JenaOWLModelWrapper reading " + owlsources[i].getKnowledgeSourcePk());
            }
            logger.debug("Loaded "+owlsources[i].getKnowledgeSourcePk());          
        }
        return ontModel;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
    
    public void setOntologySource(ResourceLoader ontologySource) {
        this.resourceLoader = ontologySource;
    }
    
    public Object getModel() {
        return getJenaOWLModel();
    }
    
    public void setModel(Model model) {
        this.jenaOWLModel = (OntModel) model;
    }
    
}
