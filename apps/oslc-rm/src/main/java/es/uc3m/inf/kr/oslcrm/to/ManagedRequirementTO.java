package es.uc3m.inf.kr.oslcrm.to;

import java.util.ArrayList;
import java.util.List;





import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import es.uc3m.inf.kr.oslcrm.Constants;

//OSLC4J should give an rdf:type of oslc_cm:ChangeRequest
@OslcNamespace(Constants.REQUIREMENTS_MANAGEMENT_NAMESPACE)
@OslcName("RequirementManagement") 
@OslcResourceShape(title = "Requirement management Resource Shape", describes = Constants.TYPE_CHANGE_REQUEST)
public class ManagedRequirementTO extends AbstractResource{

	   private final List<Person>   contributors = new ArrayList<Person>();
	   public void addContributor(final Person contributor){
	        this.contributors.add(contributor);
	    }
	   
	    @OslcDescription("The person(s) who are responsible for the work needed to manage a requiremen.")
	    @OslcName("contributor")
	    @OslcPropertyDefinition(OslcConstants.DCTERMS_NAMESPACE + "contributor")
	    @OslcRepresentation(Representation.Inline)
	    @OslcValueType(ValueType.LocalResource)
	    @OslcRange(Constants.FOAF_PERSON)
	    @OslcTitle("Contributors")
	    public List<Person> getContributors()
	    {
	        return contributors;
	    }
}
