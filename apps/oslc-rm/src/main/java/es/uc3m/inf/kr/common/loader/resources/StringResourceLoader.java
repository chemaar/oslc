package es.uc3m.inf.kr.common.loader.resources;

import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import es.uc3m.inf.kr.common.exceptions.DocumentBuilderException;
import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;
import es.uc3m.inf.kr.common.utils.DocumentBuilderHelper;

/**
 *
 * This class implements the interface ResourceLoader loading the data
 * from a String.
 *
 */
public class StringResourceLoader  implements ResourceLoader {
    
    private static final Logger logger = Logger.getLogger(StringResourceLoader.class);

    private String content;
    
    public StringResourceLoader(String content) {
       this.content = content;
    }

    public Document getKnowledgeResourceAsDocument(String filename) throws ResourceNotFoundException {
        try {
            return DocumentBuilderHelper.getDocumentFromString(content);
        } catch (DocumentBuilderException ex) {
            java.util.logging.Logger.getLogger(StringResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResourceNotFoundException("Can not parse content.");
        }
    }
    

  
    public KnowledgeResourcesTO[] getKnowledgeResources() {
        KnowledgeResourcesTO knowledgeResourcesTO = new KnowledgeResourcesTO();
        InputStream knowledgeSourceData = new ByteArrayInputStream(content.getBytes());
        knowledgeResourcesTO.setKnowledgeSourceData(knowledgeSourceData);
        return  new KnowledgeResourcesTO[]{knowledgeResourcesTO};
    }





}
