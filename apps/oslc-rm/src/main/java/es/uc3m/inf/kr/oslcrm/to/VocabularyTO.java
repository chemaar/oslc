package es.uc3m.inf.kr.oslcrm.to;


import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import es.uc3m.inf.kr.oslcrm.Constants;

@OslcNamespace(Constants.REQUIREMENTS_MANAGEMENT_NAMESPACE)
@OslcName("VocabularyElement") 
@OslcResourceShape(title = "Vocabulary management Resource Shape", describes = Constants.TYPE_CHANGE_REQUEST)
public class VocabularyTO extends ManagedVocabularyTO {
	private String definition = null;	
	
	@OslcDescription("The Requirement definition.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcPropertyDefinition(Constants.REQUIREMENTS_MANAGEMENT_DOMAIN + "definition")
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
    @OslcRange("xsd:string")
    @OslcTitle("Definition")
	public String getDefinition() {
		return definition;
	}


	public void setDefinition(String definition) {
		this.definition = definition;
	}
	

	
}
