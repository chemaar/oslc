package es.uc3m.inf.kr.km.appserv;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uc3m.inf.kr.common.utils.ApplicationContextLocator;

public class KnowledgeManagementAppServTest {

	@Test
	public void test() {
		KnowledgeManagementAppServ appServ = (KnowledgeManagementAppServ) ApplicationContextLocator.
				getApplicationContext().getBean(KnowledgeManagementAppServ.class.getSimpleName());
	}

}
