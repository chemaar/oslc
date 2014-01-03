package es.uc3m.inf.kr.rm.dao;

import java.util.List;

import es.uc3m.inf.kr.rm.to.RequirementTO;

public interface RequirementDAO {

	List<RequirementTO> getRequirements();

	RequirementTO getRequirement(String requirementId);

}
