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
		assertEquals(66, appServ.listClasses().size());
		assertEquals(75, appServ.listProperties().size());
		assertEquals(140, appServ.listInstances().size());
		assertEquals(1, appServ.listInstancesOf(new ResourceTO("http://threusecompany/km/demo/System")).size());
		
	}

}
