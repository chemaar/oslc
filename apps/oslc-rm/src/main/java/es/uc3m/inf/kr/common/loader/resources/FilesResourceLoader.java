package es.uc3m.inf.kr.common.loader.resources;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.exceptions.ResourceNotFoundException;
import es.uc3m.inf.kr.common.pk.KnowledgeSourcePK;
import es.uc3m.inf.kr.common.to.KnowledgeResourcesTO;
import es.uc3m.inf.kr.common.utils.DocumentBuilderHelper;

/**
 *
 * This class implements the interface ResourceLoader loading the data
 * from a file referenced by a name of the current classpath.
 *
 */
public class FilesResourceLoader  implements ResourceLoader {
    
    private static final Logger logger = Logger.getLogger(FilesResourceLoader.class);

    private String []resourceNames;

	private String format = "";
    
    public FilesResourceLoader(String[] filenames, String format) {
        this.resourceNames = filenames;
        this.format = format;
    }
    public FilesResourceLoader(List <String>filenames, String format) {
        this.resourceNames = filenames.toArray(new String[filenames.size()]);
        this.format = format;
    }

    public FilesResourceLoader(String[] filenames) {
        this.resourceNames = filenames;
    }
    public FilesResourceLoader(List <String>filenames) {
        this.resourceNames = filenames.toArray(new String[filenames.size()]);
    }
    
    
    protected InputStream openInputStream(String filename) throws FileNotFoundException {
        logger.debug("Opening resource input stream for filename: " + filename);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream(filename);
        if (in == null) {
            logger.error("Resource file not found: " + filename);
            throw new FileNotFoundException(filename);
        } else {
            return in;
        }
    }
    
    

    public Document getKnowledgeResourceAsDocument(String filename) throws ResourceNotFoundException {
        try {
        	logger.debug("Parsing resource filename: " + filename);
            InputStream in = openInputStream(filename);
            Document document = DocumentBuilderHelper.getDocumentFromInputStream(in);
            logger.debug("Finished parsing of resource filename: " + filename);
            in.close();
            return document;
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage()); // propagate
        } catch (Exception e) {
            throw new KRModelException(e, "Moldeas files resource loaded: parsing Resource file " + filename);
        }
    }
    

  
    public KnowledgeResourcesTO[] getKnowledgeResources() {
        Collection<KnowledgeResourcesTO> ontologies = new LinkedList<KnowledgeResourcesTO>();
        String file = "";
        try {
            for (int i = 0 ;i< resourceNames.length;i++) {
                file =  resourceNames[i]; 
                KnowledgeSourcePK ontologyPK = new KnowledgeSourcePK(file);
                KnowledgeResourcesTO resource = new KnowledgeResourcesTO(
                		(this.openInputStream(file)),ontologyPK);
                ontologies.add(resource);
            }
        } catch (FileNotFoundException e) {
            throw new KRModelException(e, "Resource Files getting resource file:  "+file);
        }
        return  ontologies.toArray(new KnowledgeResourcesTO[ontologies.size()]);
    }
	public String getFormat() {
		return this.format;
	}





}
