package es.uc3m.inf.kr.oslcrm.dao;

import java.util.LinkedList;
import java.util.List;

import es.uc3m.inf.kr.oslcrm.to.RequirementTO;

public class DummyRequirementDAOImpl implements RequirementDAO{

	public List<RequirementTO> getRequirements() {
		List<RequirementTO> requirements = new LinkedList<RequirementTO>();
		return requirements;
	}

	public RequirementTO getRequirement(String requirementId) {
		return new RequirementTO();
	}

}
