/**
 * (c) Copyright 2011 WESO, Computer Science Department,
 * Facultad de Ciencias, University of Oviedo, Oviedo, Asturias, Spain, 33007
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package es.uc3m.inf.kr.common.loader;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
//import org.mindswap.pellet.jena.PelletReasonerFactory;




import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;


/**
 *
 * This class implements the interface QuodModelWrapper loading (with a reasoner) the data from a file and
 * returning a Jena OntoModel.
 *
 */
public class JenaOWLReasonerModelWrapper implements KRModelWrapper {
  

    private static final Logger logger = Logger.getLogger(JenaOWLReasonerModelWrapper.class);

    private ResourceLoader resourceLoader;    
    private OntModel jenaOWLModel;
    
    
    public JenaOWLReasonerModelWrapper(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    private Model getJenaOWLModel() {   // NOTE: !synchronized
        if (loadJenaOWLModel(this.resourceLoader)) {  
        	  logger.debug("Loaded Jena Owl (with reasoning) model");
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
    
    private OntModel createJenaOWLModel(ResourceLoader owlSource) throws ResourceNotFoundException {
        KnowledgeResourcesTO[] owlsources = null;
        Reasoner reasoner = null; //FIXME: PelletReasonerFactory.theInstance().create();
        OntDocumentManager dm = OntDocumentManager.getInstance();
        dm.setProcessImports(false);
        OntModelSpec spec = new OntModelSpec( OntModelSpec.OWL_DL_MEM);
        spec.setDocumentManager(dm);        
        //spec.setReasoner(new OWLMicroReasoner(OWLMicroReasonerFactory.theInstance()));
        spec.setReasoner(reasoner);
        OntModel ontModel = ModelFactory.createOntologyModel( spec, null );
        owlsources = owlSource.getKnowledgeResources();
        logger.debug("Loading with reasoner " + owlsources.length  +" resources into the model");
        for ( int i = 0; i< owlsources.length ; i++ ) {                   
            final InputStream is = owlsources[i].getKnowledgeSourceData();
            logger.debug("Loading OWL Reasoner "+owlsources[i].getKnowledgeSourcePk());
            ontModel.read(is, "");   
            try {
                is.close();
            } catch (IOException e) {
                throw new KRModelException(e, "JenaOWLReasonerModelWrapper reading " + owlsources[i].getKnowledgeSourcePk());
            }
            logger.debug("Loaded  with reasoner "+owlsources[i].getKnowledgeSourcePk());
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
