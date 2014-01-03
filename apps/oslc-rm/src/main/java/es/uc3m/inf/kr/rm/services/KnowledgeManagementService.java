package es.uc3m.inf.kr.rm.services;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

import es.uc3m.inf.kr.common.to.ResourceTO;
import es.uc3m.inf.kr.common.utils.ApplicationContextLocator;
import es.uc3m.inf.kr.km.appserv.KnowledgeManagementAppServ;
import es.uc3m.inf.kr.rm.Constants;

@OslcService(Constants.VOCABULARY_MANAGEMENT_DOMAIN)
@Path("km")
public class KnowledgeManagementService {

	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;
	@Context private UriInfo uriInfo;
	KnowledgeManagementAppServ appServ;

	public KnowledgeManagementService(){
		super();
		appServ = (KnowledgeManagementAppServ) ApplicationContextLocator.
				getApplicationContext().getBean(KnowledgeManagementAppServ.class.getSimpleName());
	}

	@OslcDialogs(
			{
				@OslcDialog
				(
						title = "Knowledge Management Selection Dialog",
						label = "Knowledge Management Selection Dialog",
						uri = "/km/selector",
						hintWidth = "525px",
						hintHeight = "325px",
						resourceTypes = {Constants.TYPE_KNOWLEDGE_ELEMENT},
						usages = {OslcConstants.OSLC_USAGE_DEFAULT}
						)

			})
	@OslcQueryCapability
	(
			title = "Vocabulary Management Query Capability",
			label = "Vocabulary Management Catalog Query",
			resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Constants.PATH_VOCABULARY_REQUEST,
			resourceTypes = {Constants.TYPE_KNOWLEDGE_ELEMENT},
			usages = {OslcConstants.OSLC_USAGE_DEFAULT}
			)

	@GET
	@Path("listClasses")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<ResourceTO> listClasses() throws IOException, ServletException {
		try {
			List<ResourceTO> classes = this.appServ.listClasses();
			return classes;
		} catch (RuntimeException e) {
			e.printStackTrace();
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}


	}


	@GET
	@Path("listProperties")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<ResourceTO> listProperties() throws IOException, ServletException {
		try {
			return this.appServ.listProperties();
		} catch (RuntimeException e) {
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GET
	@Path("listInstances")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<ResourceTO> listInstances() throws IOException, ServletException {
		try {
			return this.appServ.listInstances();
		} catch (RuntimeException e) {
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GET
	@Path("listInstancesOf")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<ResourceTO> listInstancesOf(@QueryParam("uri") String uri ) throws IOException, ServletException {
		try {
			return this.appServ.listInstancesOf(new ResourceTO(uri));
		} catch (RuntimeException e) {
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	@GET
	@Path("listPropertiesOf")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public List<ResourceTO> listPropertiesOf(@QueryParam("uri") String uri) throws IOException, ServletException {
		try {
			return this.appServ.listPropertiesOf(new ResourceTO(uri));
		} catch (RuntimeException e) {
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GET
	@Path("valueOf")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public ResourceTO valueOf(@QueryParam("uri") String uri, @QueryParam("property") String property) throws IOException, ServletException {
		try {
			ResourceTO valueOf = this.appServ.valueOf(new ResourceTO(uri),new ResourceTO(property));
			return valueOf;
		} catch (RuntimeException e) {
			 throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
 
}
