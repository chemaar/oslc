package es.uc3m.inf.kr.oslcrm.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
	 
	    @GET
	    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	    public List<RequirementTO> getChangeRequests() throws IOException, ServletException {
	    
		 List<RequirementTO> requirements = new LinkedList<RequirementTO>();
		 RequirementTO req = new RequirementTO();
		// req.setDefinition("My cool definition");
		 try {
			req.setAbout(new URI("http://uri.req"));	
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 requirements.add(req);
		 return requirements;
	 }
	    
	  
}
