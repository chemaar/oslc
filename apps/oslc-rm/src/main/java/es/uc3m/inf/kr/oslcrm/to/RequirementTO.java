package es.uc3m.inf.kr.oslcrm.to;


import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.model.Occurs;

import es.uc3m.inf.kr.oslcrm.Constants;

@OslcNamespace(Constants.REQUIREMENTS_MANAGEMENT_NAMESPACE)
@OslcName("RequirementManagement") 
@OslcResourceShape(title = "Requirement management Resource Shape", describes = Constants.TYPE_CHANGE_REQUEST)
public class RequirementTO extends ManagedRequirementTO {
//	private String definition = null;	
//	
//	@OslcDescription("The Requirement definition.")
//    @OslcOccurs(Occurs.ZeroOrOne)
//    @OslcPropertyDefinition(Constants.REQUIREMENTS_MANAGEMENT_DOMAIN + "definition")
//    @OslcTitle("Definition")
//	public String getDefintion() {
//		return definition;
//	}
//
//	public String getDefinition() {
//		return definition;
//	}
//
//	public void setDefinition(String definition) {
//		this.definition = definition;
//	}
//	

	
}
