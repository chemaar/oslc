package es.uc3m.inf.kr.oslcrm.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.lyo.core.query.ParseException;
import org.eclipse.lyo.core.query.Properties;
import org.eclipse.lyo.core.query.QueryUtils;
import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

import es.uc3m.inf.kr.oslcrm.Constants;
import es.uc3m.inf.kr.oslcrm.to.Person;
import es.uc3m.inf.kr.oslcrm.to.VocabularyTO;

@OslcService(Constants.REQUIREMENTS_MANAGEMENT_DOMAIN)
@Path("vocabularyManagement")
//@Path("{productId}/requirementManagement")
public class KRVocabularyManagementService {

	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;
	@Context private UriInfo uriInfo;

	public KRVocabularyManagementService(){
		super();
	}

	@OslcDialogs(
			{
				@OslcDialog
				(
						title = "Requirements Management Selection Dialog",
						label = "Requirements Management Selection Dialog",
						//uri = "/{productId}/requirementManagement/selector",
						uri = "/requirementManagement/selector",
						hintWidth = "525px",
						hintHeight = "325px",
						resourceTypes = {Constants.TYPE_CHANGE_REQUEST},
						usages = {OslcConstants.OSLC_USAGE_DEFAULT}
						)

			})
	@OslcQueryCapability
	(
			title = "Requirements Management Query Capability",
			label = "Requirements Management Catalog Query",
			resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Constants.PATH_CHANGE_REQUEST,
			resourceTypes = {Constants.TYPE_CHANGE_REQUEST},
			usages = {OslcConstants.OSLC_USAGE_DEFAULT}
			)

	@GET
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<VocabularyTO> getVocabularyConcepts() throws IOException, ServletException {

		List<VocabularyTO> vocabulary = new LinkedList<VocabularyTO>();

		// req.setDefinition("My cool definition");
		try {
			for(int i = 0; i<1;i++){
				vocabulary.add(createElement(i));
			}

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vocabulary;
	}


	 /**
     * RDF/XML, XML and JSON representation of a change request collection
     * 
     * TODO:  add query support
     * 
     * @param conceptId
     * @param where
     * @param select
     * @param prefix
     * @param pageString
     * @param orderBy
     * @param searchTerms
     * @param paging
     * @param pageSize
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @GET
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public List<VocabularyTO> getVocabularyElement       (@PathParam("conceptID")         final String conceptId,
    		                                 	     	 @QueryParam("oslc.where")       final String where,
    		                                 		     @QueryParam("oslc.select")      final String select,
    		                                 		     @QueryParam("oslc.prefix")      final String prefix,
    		                                             @QueryParam("page")             final String pageString,
    		                                             @QueryParam("oslc.orderBy")     final String orderBy,
    		                                             @QueryParam("oslc.searchTerms") final String searchTerms,
    		                                             @QueryParam("oslc.paging")      final String paging,
    		                                             @QueryParam("oslc.pageSize")    final String pageSize) throws IOException, ServletException 
    {
        boolean isPaging = false;
        
        if (paging != null) {
            isPaging = Boolean.parseBoolean(paging);
        }
        
    	int page=0;
    	
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        
    	int limit=10;
    	
    	if (isPaging && pageSize != null) {
    	    limit = Integer.parseInt(pageSize);
    	}
    	
    	Map<String, String> prefixMap;
    	
        try {
            prefixMap = QueryUtils.parsePrefixes(prefix);
        } catch (ParseException e) {
           throw new IOException(e);
        }
        
        addDefaultPrefixes(prefixMap);
        
        Properties properties;
        
        if (select == null) {
            properties = QueryUtils.WILDCARD_PROPERTY_LIST;
        } else {
            try {
                properties = QueryUtils.parseSelect(select, prefixMap);
            } catch (ParseException e) {
                throw new IOException(e);
            }
        }
        
        Map<String, Object> propMap =
            QueryUtils.invertSelectedProperties(properties);
        
        final List<VocabularyTO> results = null;
//            BugzillaManager.getBugsByProduct(httpServletRequest, conceptId, page, limit,
//                                             where, prefixMap,
//                                             propMap, orderBy, searchTerms);
        
        Object nextPageAttr = httpServletRequest.getAttribute(Constants.NEXT_PAGE);
        
        if (! isPaging && nextPageAttr != null) {
            
            String location = 
                uriInfo.getBaseUri().toString() + uriInfo.getPath() + '?' +
                (where != null ? ("oslc.where=" + URLEncoder.encode(where, "UTF-8") + '&') : "") +
                (select != null ? ("oslc.select=" + URLEncoder.encode(select, "UTF-8") + '&') : "") +
                (prefix != null ? ("oslc.prefix=" + URLEncoder.encode(prefix, "UTF-8") + '&') : "") +
                (orderBy != null ? ("oslc.orderBy=" + URLEncoder.encode(orderBy, "UTF-8") + '&') : "") +
                (searchTerms != null ? ("oslc.searchTerms=" + URLEncoder.encode(searchTerms, "UTF-8") + '&') : "") +
                "oslc.paging=true&oslc.pageSize=" + limit;
                
            try {
                throw new WebApplicationException(Response.temporaryRedirect(new URI(location)).build());
            } catch (URISyntaxException e) {
                // XXX - Can't happen
                throw new IllegalStateException(e);
            }
        }
        
        httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_SELECTED_PROPERTIES,
                                        propMap);
        
        if (nextPageAttr != null) {
            
            String location = 
                uriInfo.getBaseUri().toString() + uriInfo.getPath() + '?' +
                (where != null ? ("oslc.where=" + URLEncoder.encode(where, "UTF-8") + '&') : "") +
                (select != null ? ("oslc.select=" + URLEncoder.encode(select, "UTF-8") + '&') : "") +
                (prefix != null ? ("oslc.prefix=" + URLEncoder.encode(prefix, "UTF-8") + '&') : "") +
                (orderBy != null ? ("oslc.orderBy=" + URLEncoder.encode(orderBy, "UTF-8") + '&') : "") +
                (searchTerms != null ? ("oslc.searchTerms=" + URLEncoder.encode(searchTerms, "UTF-8") + '&') : "") +
                "oslc.paging=true&oslc.pageSize=" + limit + "&page=" + nextPageAttr;
                
            httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE,
                                            location);

        }

        return results;
    }

    private static void addDefaultPrefixes(final Map<String, String> prefixMap)  {
        //recursivelyCollectNamespaceMappings(prefixMap, BugzillaChangeRequest.class);
    }  
    
    
	public static VocabularyTO createElement(int i) throws URISyntaxException{
		VocabularyTO vocabularyElement = new VocabularyTO();
		vocabularyElement.setAbout(new URI("http://threusecompany/km/taxonomy/demo/1381307095/c"+i));	
		vocabularyElement.setDefinition("My definition");
		Person contributor = new Person();
		contributor.setName("Jose");
		contributor.setMbox("mailto:josemaria.alvarez@uc3m.es");
		contributor.setUri(new URI("http://josemalvarez.es/foaf.rdf#me"));
		vocabularyElement.addContributor(contributor );
		vocabularyElement.setCreationDate(GregorianCalendar.getInstance().getTime());
		vocabularyElement.setModifiedDate(GregorianCalendar.getInstance().getTime());
		vocabularyElement.setRDFSLabel("RDFS Label");
		vocabularyElement.setPrefLabel("Preferred Label");
		vocabularyElement.setAltLabel("Alt Label");
		vocabularyElement.setHiddenLabel("Hidden Label");
		vocabularyElement.setChangeNote("Change note");
		vocabularyElement.setEditorialNote("Editorial Note");
		vocabularyElement.setHistoryNote("History Note");
		vocabularyElement.setScopeNote("Scope Note");
		vocabularyElement.setNotation("Notation");
		vocabularyElement.setLevel("Level");
		vocabularyElement.setSubject("Subject");
		return vocabularyElement;
	}
}
