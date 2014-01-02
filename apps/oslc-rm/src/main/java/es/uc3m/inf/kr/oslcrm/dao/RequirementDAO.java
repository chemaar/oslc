package es.uc3m.inf.kr.oslcrm.dao;

import java.util.List;

import es.uc3m.inf.kr.oslcrm.to.RequirementTO;

public interface RequirementDAO {

	List<RequirementTO> getRequirements();

	RequirementTO getRequirement(String requirementId);

}
