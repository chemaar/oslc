package es.uc3m.inf.kr.rm.appserv;

import java.util.List;

import es.uc3m.inf.kr.rm.dao.DummyRequirementDAOImpl;
import es.uc3m.inf.kr.rm.dao.RequirementDAO;
import es.uc3m.inf.kr.rm.to.RequirementTO;

public class RequirementApplicationService {
	
	RequirementDAO dao;
	
	public RequirementApplicationService(){
		this.dao = new DummyRequirementDAOImpl();
	}

	public List<RequirementTO> getRequirements() {
		return this.dao.getRequirements();
	}

	public RequirementTO getRequirement(String requirementId) {
		return this.dao.getRequirement(requirementId);
	}

}
