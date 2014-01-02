package es.uc3m.inf.kr.oslcrm.to;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import es.uc3m.inf.kr.oslcrm.Constants;

@OslcNamespace(Constants.REQUIREMENTS_MANAGEMENT_NAMESPACE)
@OslcName("Requirement") 
@OslcResourceShape(title = "Requirement management Resource Shape", describes = Constants.TYPE_REQUIREMENT_REQUEST)
public class RequirementTO {

	
	private String title = "";
	private String description = "";
	private String definition = "";	
	private String identifier = "";
	private String shortTitle = "";
	private String subject = "";
	private List<AbstractResource> creator = new LinkedList<AbstractResource>();
	private List<AbstractResource> contributor = new LinkedList<AbstractResource>();
	private Date created = null;
	private Date modified = null;
	private List<AbstractResource> elaboratedBy;
	private List<AbstractResource> elaborates;
	private List<AbstractResource> specifiedBy;
	private List<AbstractResource> specifies;
	private List<AbstractResource> affectedBy;
	private List<AbstractResource> trackedBy;
	private List<AbstractResource> implementedBy;
	private List<AbstractResource> validatedBy;
	private List<AbstractResource> satisfiedBy;
	private List<AbstractResource> satisfies;
	private List<AbstractResource> decomposedBy;
	private List<AbstractResource> decomposes;
	private List<AbstractResource> constrainedBy;
	private List<AbstractResource> constraints;
	private List<AbstractResource> uses;
	

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



	@OslcDescription("The Requirement description.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.DCTERMS_DESCRIPTION)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("title")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getShortTitle() {
		return shortTitle;
	}


	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public List<AbstractResource> getCreator() {
		return creator;
	}


	public void setCreator(List<AbstractResource> creator) {
		this.creator = creator;
	}


	public List<AbstractResource> getContributor() {
		return contributor;
	}


	public void setContributor(List<AbstractResource> contributor) {
		this.contributor = contributor;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getModified() {
		return modified;
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}


	public List<AbstractResource> getElaboratedBy() {
		return elaboratedBy;
	}


	public void setElaboratedBy(List<AbstractResource> elaboratedBy) {
		this.elaboratedBy = elaboratedBy;
	}


	public List<AbstractResource> getElaborates() {
		return elaborates;
	}


	public void setElaborates(List<AbstractResource> elaborates) {
		this.elaborates = elaborates;
	}


	public List<AbstractResource> getSpecifiedBy() {
		return specifiedBy;
	}


	public void setSpecifiedBy(List<AbstractResource> specifiedBy) {
		this.specifiedBy = specifiedBy;
	}


	public List<AbstractResource> getSpecifies() {
		return specifies;
	}


	public void setSpecifies(List<AbstractResource> specifies) {
		this.specifies = specifies;
	}


	public List<AbstractResource> getAffectedBy() {
		return affectedBy;
	}


	public void setAffectedBy(List<AbstractResource> affectedBy) {
		this.affectedBy = affectedBy;
	}


	public List<AbstractResource> getTrackedBy() {
		return trackedBy;
	}


	public void setTrackedBy(List<AbstractResource> trackedBy) {
		this.trackedBy = trackedBy;
	}


	public List<AbstractResource> getImplementedBy() {
		return implementedBy;
	}


	public void setImplementedBy(List<AbstractResource> implementedBy) {
		this.implementedBy = implementedBy;
	}


	public List<AbstractResource> getValidatedBy() {
		return validatedBy;
	}


	public void setValidatedBy(List<AbstractResource> validatedBy) {
		this.validatedBy = validatedBy;
	}


	public List<AbstractResource> getSatisfiedBy() {
		return satisfiedBy;
	}


	public void setSatisfiedBy(List<AbstractResource> satisfiedBy) {
		this.satisfiedBy = satisfiedBy;
	}


	public List<AbstractResource> getSatisfies() {
		return satisfies;
	}


	public void setSatisfies(List<AbstractResource> satisfies) {
		this.satisfies = satisfies;
	}


	public List<AbstractResource> getDecomposedBy() {
		return decomposedBy;
	}


	public void setDecomposedBy(List<AbstractResource> decomposedBy) {
		this.decomposedBy = decomposedBy;
	}


	public List<AbstractResource> getDecomposes() {
		return decomposes;
	}


	public void setDecomposes(List<AbstractResource> decomposes) {
		this.decomposes = decomposes;
	}


	public List<AbstractResource> getConstrainedBy() {
		return constrainedBy;
	}


	public void setConstrainedBy(List<AbstractResource> constrainedBy) {
		this.constrainedBy = constrainedBy;
	}


	public List<AbstractResource> getConstraints() {
		return constraints;
	}


	public void setConstraints(List<AbstractResource> constraints) {
		this.constraints = constraints;
	}


	public List<AbstractResource> getUses() {
		return uses;
	}


	public void setUses(List<AbstractResource> uses) {
		this.uses = uses;
	}

	

}
