package es.uc3m.inf.kr.km.appserv;


import java.util.List;

import org.apache.log4j.Logger;

import es.uc3m.inf.kr.common.to.ModelTO;
import es.uc3m.inf.kr.common.to.OntologyDataTO;
import es.uc3m.inf.kr.common.to.ResourceTO;
import es.uc3m.inf.kr.pscs.to.GraphTO;


public class KnowledgeManagementAppServ {

        protected static Logger logger = Logger.getLogger(KnowledgeManagementAppServ.class);
        private KnowledgeManagementFacade facade;

        public KnowledgeManagementAppServ(KnowledgeManagementFacade facade) {
                super();
                this.facade = facade;
        }

        public KnowledgeManagementAppServ() {
                super();
                this.facade = new KnowledgeManagementFacade();
        }

        public  boolean loadResource(ResourceTO resource){
                logger.debug("Loading resource "+resource);
                return this.facade.loadResource(resource);
        }

        public  boolean addOntology(OntologyDataTO ontology){
                logger.debug("Loading ontology "+ontology);
                return this.facade.addOntology(ontology);
        }

        public  List<OntologyDataTO> listOntologies(){
                logger.debug("Listing ontologies...");
                return this.facade.listOntologies();
        }

        public  OntologyDataTO getOntology(OntologyDataTO ontology){
                logger.debug("Getting ontology "+ontology);
                return this.facade.getOntology(ontology);
        }

        public  ModelTO getModel(){
                logger.debug("Getting model...");
                return this.facade.getModel();
        }

        public  boolean newModel(){
                logger.debug("Creating new empty model...");
                return this.facade.newModel();
        }

        public  boolean newModel(OntologyDataTO ontology){
                logger.debug("Creating new model from ontology "+ontology);
                return this.facade.newModel(ontology);
        }

        //Listing methods
        public  List<ResourceTO> listClasses(){
                logger.debug("Listing classes...");
                return this.facade.listClasses();
        }

        public  List<ResourceTO> listProperties(){
                logger.debug("Listing properties...");
                return this.facade.listProperties();
        }

        public  List<ResourceTO> listInstances(){
                logger.debug("Listing instances...");
                return this.facade.listInstances();
        }

        public  List<ResourceTO> listInstancesOf(ResourceTO clazz){
                logger.debug("Listing instances of "+clazz);
                return this.facade.listInstancesOf(clazz);
        }

        
        public  List<ResourceTO> listPropertiesOf(ResourceTO clazz){
                logger.debug("Listing properties of "+clazz);
                return this.facade.listPropertiesOf(clazz);
        }

  
        //Resource creation
        public  boolean addClass(ResourceTO clazz, ResourceTO parent){
                logger.debug("Adding class "+clazz+" parent "+parent);
                return this.facade.addClass(clazz, parent);
        }

        public  boolean addInstance(ResourceTO instance, ResourceTO clazz){
                logger.debug("Adding instance "+instance+" class "+clazz);
                return this.facade.addInstance(instance, clazz);
        }

        public  boolean addProperty(ResourceTO property,
                        ResourceTO resource1, ResourceTO resource2){
                logger.debug("Adding prperty "+property+" between class "+resource1+" and "+resource2);
                return this.facade.addProperty(property, resource1, resource2);
        }

        public  boolean createProperty(ResourceTO property){
                logger.debug("Creating prperty "+property);
                return this.facade.createProperty(property);
        }

        public  ResourceTO getClass(ResourceTO clazz){
                logger.debug("Getting class "+clazz);
                return this.facade.getClass(clazz);
        }

        public  boolean removeClass(ResourceTO clazz){
                logger.debug("Removing class "+clazz);
                return this.facade.removeClass(clazz);
        }

        public  boolean removeInstance(ResourceTO instance){
                logger.debug("Removing instance "+instance);
                return this.facade.removeInstance(instance);
        }

        public  boolean removeProperty(ResourceTO property){
                logger.debug("Removing property "+property);
                return this.facade.removeProperty(property);
        }

        public  ResourceTO getProperty(ResourceTO property){
                logger.debug("Getting property "+property);
                return this.facade.getProperty(property);
        }

        public  ResourceTO getInstance(ResourceTO instance){
                logger.debug("Getting instance "+instance);
                return this.facade.getInstance(instance);
        }

		public ResourceTO valueOf(ResourceTO resource,
				ResourceTO property) {
			return this.facade.valueOf(resource, property);
           }
		
		public GraphTO createGraph(String uri){
			return this.facade.createGraph(uri);
		}
		

}