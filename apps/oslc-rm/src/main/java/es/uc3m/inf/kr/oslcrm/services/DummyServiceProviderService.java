package es.uc3m.inf.kr.oslcrm.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;

@OslcService(OslcConstants.OSLC_CORE_DOMAIN)
@Path("dummyServiceProviders")
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
		return new ServiceProvider[0];
		//return ServiceProviderCatalogSingleton.getServiceProviders(httpServletRequest);
	}
}
