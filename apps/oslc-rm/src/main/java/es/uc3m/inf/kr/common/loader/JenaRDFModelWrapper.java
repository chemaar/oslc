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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;

/**
 *
 * This class implements the interface QuodModelWrapper loading the data from a file and
 * returning a Jena Model.
 *
 */
public class JenaRDFModelWrapper implements KRModelWrapper {

    private static final Logger logger = Logger.getLogger(JenaRDFModelWrapper.class);

    private ResourceLoader resourceLoader;
    private Model jenaRDFModel;
    private String format = "";
    
    public JenaRDFModelWrapper(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    public JenaRDFModelWrapper(ResourceLoader resourceLoader, String format) {
        this.resourceLoader = resourceLoader;
        this.format = format;
    }
    
    
    public synchronized void forceReload() {
        jenaRDFModel = null; // the model will be reloaded on demand
    }
    
    /**
     * @return an instance of Model
     */
    private Model getJenaRDFModel() {   // NOTE: !synchronized
        if (loadJenaRDFModel(this.resourceLoader)) {  
        	logger.debug("Loaded Jena Rdf model");
        }            
        return jenaRDFModel;
    }
    
    
    private synchronized boolean loadJenaRDFModel(ResourceLoader rdfSource)  {
        if(this.jenaRDFModel == null){
            logger.debug("Jena model for is null: creating new Jena Model");
            //Create JenaModel               
            jenaRDFModel = createRDFModel(rdfSource);            
            return true;
        } else {
            return false;
        }        
    }
    
    private Model createRDFModel(ResourceLoader rdfSource) throws ResourceNotFoundException {
        KnowledgeResourcesTO[] rdfsources = null;
        Model model =ModelFactory.createDefaultModel();
        rdfsources = rdfSource.getKnowledgeResources();
        logger.debug("Loading " + rdfsources.length  +" resources into the model");
        for ( int i = 0; i< rdfsources.length ; i++ ) {                   
            final InputStream is = rdfsources[i].getKnowledgeSourceData();
            logger.debug("Loading RDF "+rdfsources[i].getKnowledgeSourcePk());
            model.read(is, "",this.format);    
            try {
                is.close();
            } catch (IOException e) {
                throw new KRModelException(e, "JenaRDFModelWrapper reading " + rdfsources[i].getKnowledgeSourcePk());
            }
            logger.debug("RDF stream loaded, model contains " + model.size() + " triplets");          
        }        
        return model;
    }

    /**
     * @return Returns the ontologySource.
     */
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
    
    /**
     * @param ontologySource The ontologySource to set.
     */
    public void setOntologySource(ResourceLoader ontologySource) {
        this.resourceLoader = ontologySource;
    }

    public Object getModel() {
        return getJenaRDFModel();
    }
    
    public void setModel(Model model) {
        this.jenaRDFModel = (Model) model;
    }


}
