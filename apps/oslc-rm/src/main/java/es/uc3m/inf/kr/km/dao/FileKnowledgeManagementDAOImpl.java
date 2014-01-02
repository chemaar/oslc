package es.uc3m.inf.kr.km.dao;

import org.apache.log4j.Logger;

import es.uc3m.inf.kr.common.loader.JenaOWLModelWrapper;
import es.uc3m.inf.kr.common.loader.JenaRDFModelWrapper;
import es.uc3m.inf.kr.common.loader.KRModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.FilesResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;

public class FileKnowledgeManagementDAOImpl implements KnowledgeManagementDAO {
        
        protected static Logger logger = Logger.getLogger(FileKnowledgeManagementDAOImpl.class);
        private KRModelWrapper ontModel;
        
        public FileKnowledgeManagementDAOImpl(KRModelWrapper rdfModel) {
        	  this.ontModel = rdfModel;
		}



		public KRModelWrapper load(ResourceLoader loader) {
                JenaRDFModelWrapper wrapper = new JenaRDFModelWrapper(loader); //FIXME
                this.ontModel = wrapper;
                return wrapper;
        }

 

        public KRModelWrapper getModel() {
                if(this.ontModel == null){
                        ResourceLoader resourceLoader = 
                                new FilesResourceLoader(new String[]{});                        
                        this.load(resourceLoader);
                }
                return this.ontModel;
        }
        

}

