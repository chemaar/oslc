package es.uc3m.inf.kr.oslcrm.services;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

import es.uc3m.inf.kr.oslcrm.Constants;
import es.uc3m.inf.kr.oslcrm.to.RequirementTO;

@OslcService(Constants.REQUIREMENTS_MANAGEMENT_DOMAIN)
@Path("requirementManagement")
//@Path("{productId}/requirementManagement")
public class KRRequirementsManagementService {

	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;
	@Context private UriInfo uriInfo;
	
	public KRRequirementsManagementService(){
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
	 /**
	     * RDF/XML, XML and JSON representation of a change request collection
	     * 
	     * TODO:  add query support
	     * 
	     * @param productId
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
	    public List<RequirementTO> getChangeRequests(@PathParam("productId")         final String productId,
	    		                                 	     	 @QueryParam("oslc.where")       final String where,
	    		                                 		     @QueryParam("oslc.select")      final String select,
	    		                                 		     @QueryParam("oslc.prefix")      final String prefix,
	    		                                             @QueryParam("page")             final String pageString,
	    		                                             @QueryParam("oslc.orderBy")     final String orderBy,
	    		                                             @QueryParam("oslc.searchTerms") final String searchTerms,
	    		                                             @QueryParam("oslc.paging")      final String paging,
	    		                                             @QueryParam("oslc.pageSize")    final String pageSize) throws IOException, ServletException {
	    
		 List<RequirementTO> requirements = new LinkedList<RequirementTO>();
		 return requirements;
	 }
	    
	  
}
