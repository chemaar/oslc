package es.uc3m.inf.kr.oslcrm.services;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.junit.Test;

import es.uc3m.inf.kr.rm.services.DummyServiceProviderService;

public class DummyServiceProviderServiceTest {

	@Test
	public void test() {
		DummyServiceProviderService endpoint = new DummyServiceProviderService();
		ServiceProvider[] providers = endpoint.getServiceProviders();
		Assert.assertEquals(0, providers.length);
	}

}
