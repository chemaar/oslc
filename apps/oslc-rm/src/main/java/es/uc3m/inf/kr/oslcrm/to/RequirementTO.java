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
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import com.hp.hpl.jena.vocabulary.DCTerms;

import es.uc3m.inf.kr.oslcrm.Constants;

@OslcNamespace(Constants.REQUIREMENTS_MANAGEMENT_NAMESPACE)
@OslcName("Requirement") 
@OslcResourceShape(title = "Requirement management Resource Shape", describes = Constants.TYPE_REQUIREMENT_REQUEST)
public class RequirementTO {

	
	private String title = "";
	private String definition = "";	

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


	@OslcDescription("The Requirement title.")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcPropertyDefinition(Constants.DCTERMS_TITLE)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("title")
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	

}
