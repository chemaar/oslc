package es.uc3m.inf.kr.common.loader.resources;

import org.w3c.dom.Document;

import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;


/**
 * This interface indicates the set of operations to be implemented
 * for a loader of differente kind of sources (Files, Local files, String, etc.).
 */
public interface ResourceLoader {
    
    public KnowledgeResourcesTO [] getKnowledgeResources() throws ResourceNotFoundException;
    public Document getKnowledgeResourceAsDocument(String filename) throws ResourceNotFoundException;
    public String getFormat();
    
}
