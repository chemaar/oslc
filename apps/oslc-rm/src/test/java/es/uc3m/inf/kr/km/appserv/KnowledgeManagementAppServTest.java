package es.uc3m.inf.kr.km.appserv;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uc3m.inf.kr.common.to.ResourceTO;
import es.uc3m.inf.kr.common.utils.ApplicationContextLocator;

public class KnowledgeManagementAppServTest {

	@Test
	public void test() {
		KnowledgeManagementAppServ appServ = (KnowledgeManagementAppServ) ApplicationContextLocator.
				getApplicationContext().getBean(KnowledgeManagementAppServ.class.getSimpleName());
		assertEquals(5, appServ.listClasses().size());
		assertEquals(6, appServ.listProperties().size());
		assertEquals(9, appServ.listInstances().size());
		assertEquals(1, appServ.listInstancesOf(new ResourceTO("http://threusecompany/km/demo/System")).size());
		String resource = "http://threusecompany/km/demo/1381307095/car/subsystem/braking/pedal";
		String property = "http://www.w3.org/2004/02/skos/core#prefLabel";
		System.out.println(appServ.valueOf(new ResourceTO(resource), new ResourceTO(property)));
	}

}
