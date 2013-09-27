package es.uc3m.inf.kr.oslcrm.services;

import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;


@RunWith( HttpJUnitRunner.class )
public class IntegrationDummyServiceProviderServiceTest {

	private static final String URL_OSLC_RM_SERVICE = "http://localhost:8080/oslc-rm/services";

	@Rule
	public Destination restfuse = new Destination( this, URL_OSLC_RM_SERVICE );

	@Context
	private Response response;

	@HttpTest( method = Method.GET, path = "/dummyServiceProviders" ) 
	public void checkRestfuseOnlineStatus() {
		Assert.assertNotNull(response);
	}

	@HttpTest( method = Method.GET, path = "/dummyServiceProviders" ) 
	public void checkVersionContentType() {
		Assert.assertEquals("2.0",
				response.getHeaders().get("Oslc-Core-Version").get(0)
				);
		Assert.assertEquals(OslcMediaType.APPLICATION_RDF_XML,
				response.getHeaders().get("Content-Type").get(0)
				);
	}
	
	@HttpTest( method = Method.GET, path = "/dummyServiceProviders" ) 
	public void checkContentNegotiation() {
		Assert.assertEquals(OslcMediaType.APPLICATION_RDF_XML,
				response.getHeaders().get("Content-Type").get(0)
				);
	}
	
	@HttpTest( method = Method.GET, path = "/dummyServiceProviders" ) 
	public void checkContentNegotiation2() {		
		restfuse.getRequestContext().addHeader( "Accept",  OslcMediaType.APPLICATION_XML );
		Assert.assertEquals( OslcMediaType.APPLICATION_XML,
				response.getHeaders().get("Content-Type").get(0)
				);
	}
	
	

}