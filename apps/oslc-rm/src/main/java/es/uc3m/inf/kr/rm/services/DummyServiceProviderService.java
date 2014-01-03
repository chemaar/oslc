package es.uc3m.inf.kr.rm.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;

@OslcService(OslcConstants.OSLC_CORE_DOMAIN)
@Path("serviceProviders")
public class DummyServiceProviderService {
	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;

	/**
	 * RDF/XML, XML and JSON representations of an OSLC Service Provider collection
	 * @return
	 */

	@OslcDialog
	(
			title = "Service Provider Selection Dialog",
			label = "Service Provider Selection Dialog",
			uri = "",
			hintWidth = "1000px",
			hintHeight = "600px",
			resourceTypes = {OslcConstants.TYPE_SERVICE_PROVIDER},
			usages = {OslcConstants.OSLC_USAGE_DEFAULT}
			)
	@OslcQueryCapability
	(
			title = "Service Provider Query Capability",
			label = "Service Provider Query",
			resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + OslcConstants.PATH_SERVICE_PROVIDER,
			resourceTypes = {OslcConstants.TYPE_SERVICE_PROVIDER},
			usages = {OslcConstants.OSLC_USAGE_DEFAULT}
			)
	@GET
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public ServiceProvider[] getServiceProviders(){
		httpServletResponse.addHeader("Oslc-Core-Version","2.0");
		return  ServiceProviderCatalogSingleton.getServiceProviders(httpServletRequest);
	}

	/**
	 * RDF/XML, XML and JSON representations of a single OSLC Service Provider
	 * 
	 * @param serviceProviderId
	 * @return
	 */
	@GET
	@Path("{serviceProviderId}")
	@Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
	public ServiceProvider getServiceProvider(@PathParam("serviceProviderId") final String serviceProviderId){
		httpServletResponse.addHeader("Oslc-Core-Version","2.0");
		return ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);
	}

	/**
	 * OSLC compact XML representation of a single OSLC Service Provider
	 * 
	 * @param serviceProviderId
	 * @return
	 */
	@GET
	@Path("{serviceProviderId}")
	@Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML, OslcMediaType.APPLICATION_X_OSLC_COMPACT_JSON})
	public Compact getCompact(@PathParam("serviceProviderId") final String serviceProviderId)    {
		final ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);

		if (serviceProvider != null) {

			final Compact compact = new Compact();

			compact.setAbout(serviceProvider.getAbout());
			compact.setShortTitle(serviceProvider.getTitle());
			compact.setTitle(serviceProvider.getTitle());
			httpServletResponse.addHeader("Oslc-Core-Version","2.0");
			return compact;
		}

		throw new WebApplicationException(Status.NOT_FOUND);
	}



}
