package es.uc3m.inf.kr.rm.to;

import java.util.Calendar;
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

import es.uc3m.inf.kr.rm.Constants;

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
	private Date created = Calendar.getInstance().getTime();
	private Date modified = Calendar.getInstance().getTime();
	private List<AbstractResource> elaboratedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> elaborates = new LinkedList<AbstractResource>();
	private List<AbstractResource> specifiedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> specifies = new LinkedList<AbstractResource>();
	private List<AbstractResource> affectedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> trackedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> implementedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> validatedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> satisfiedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> satisfies = new LinkedList<AbstractResource>();
	private List<AbstractResource> decomposedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> decomposes = new LinkedList<AbstractResource>();
	private List<AbstractResource> constrainedBy = new LinkedList<AbstractResource>();
	private List<AbstractResource> constraints = new LinkedList<AbstractResource>();
	private List<AbstractResource> uses = new LinkedList<AbstractResource>();


	@OslcDescription("The Requirement definition.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.REQUIREMENTS_MANAGEMENT_DOMAIN + "definition")
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("definition")
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
	@OslcTitle("description")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	@OslcDescription("The Requirement identifier.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.DCTERMS_IDENTIFIER)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("identifier")
	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	@OslcDescription("The Requirement title.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.OSLC_CORE_SHORT_TITLE)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("shortTitle")
	public String getShortTitle() {
		return shortTitle;
	}


	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}


	@OslcDescription("The Requirement subject.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.DCTERMS_SUBJECT)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.String)
	@OslcRange("xsd:string")
	@OslcTitle("subject")
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	@OslcDescription("The Requirement creator(s).")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.DCTERMS_CREATOR)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcRange(Constants.FOAF_PERSON)
	@OslcTitle("creator")
	public List<AbstractResource> getCreator() {
		return creator;
	}


	public void setCreator(List<AbstractResource> creator) {
		this.creator = creator;
	}


	@OslcDescription("The Requirement contributor(s).")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.DCTERMS_CONTRIBUTOR)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcRange(Constants.FOAF_PERSON)
	@OslcTitle("creator")
	public List<AbstractResource> getContributor() {
		return contributor;
	}


	public void setContributor(List<AbstractResource> contributor) {
		this.contributor = contributor;
	}


	@OslcDescription("The date in which the element was created")
	@OslcName("created")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.DCTERMS_CREATED)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.LocalResource)
	@OslcTitle("created")
	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	@OslcDescription("The date in which the element was modified")
	@OslcName("modified")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcPropertyDefinition(Constants.DCTERMS_MODIFIED)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.LocalResource)
	@OslcTitle("modified")
	public Date getModified() {
		return modified;
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}


	@OslcDescription("The Requirement elaborated by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_ELABORATED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("elaboratedBy")
	public List<AbstractResource> getElaboratedBy() {
		return elaboratedBy;
	}


	public void setElaboratedBy(List<AbstractResource> elaboratedBy) {
		this.elaboratedBy = elaboratedBy;
	}


	@OslcDescription("The Requirement elaborates.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_ELABORATES)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("elaborates")
	public List<AbstractResource> getElaborates() {
		return elaborates;
	}


	public void setElaborates(List<AbstractResource> elaborates) {
		this.elaborates = elaborates;
	}


	@OslcDescription("The Requirement specified by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_SPECIFIED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("specifiedBy")
	public List<AbstractResource> getSpecifiedBy() {
		return specifiedBy;
	}


	public void setSpecifiedBy(List<AbstractResource> specifiedBy) {
		this.specifiedBy = specifiedBy;
	}


	@OslcDescription("The Requirement specifies.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_SPECIFIES)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("specifies")
	public List<AbstractResource> getSpecifies() {
		return specifies;
	}


	public void setSpecifies(List<AbstractResource> specifies) {
		this.specifies = specifies;
	}


	@OslcDescription("The Requirement affected by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_AFFECTED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("affectedBy")
	public List<AbstractResource> getAffectedBy() {
		return affectedBy;
	}


	public void setAffectedBy(List<AbstractResource> affectedBy) {
		this.affectedBy = affectedBy;
	}


	@OslcDescription("The Requirement tracked by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_TRACKED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("trackedBy")
	public List<AbstractResource> getTrackedBy() {
		return trackedBy;
	}


	public void setTrackedBy(List<AbstractResource> trackedBy) {
		this.trackedBy = trackedBy;
	}


	@OslcDescription("The Requirement implemented by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_IMPLEMENTED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("implementedBy")
	public List<AbstractResource> getImplementedBy() {
		return implementedBy;
	}


	public void setImplementedBy(List<AbstractResource> implementedBy) {
		this.implementedBy = implementedBy;
	}


	@OslcDescription("The Requirement validated by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_VALIDATED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("validatedBy")
	public List<AbstractResource> getValidatedBy() {
		return validatedBy;
	}


	public void setValidatedBy(List<AbstractResource> validatedBy) {
		this.validatedBy = validatedBy;
	}


	@OslcDescription("The Requirement satisfied by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_SATISFIED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("satisfiedBy")
	public List<AbstractResource> getSatisfiedBy() {
		return satisfiedBy;
	}


	public void setSatisfiedBy(List<AbstractResource> satisfiedBy) {
		this.satisfiedBy = satisfiedBy;
	}



	@OslcDescription("The Requirement satisfies.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_SATISFIES)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("satisfies")
	public List<AbstractResource> getSatisfies() {
		return satisfies;
	}


	public void setSatisfies(List<AbstractResource> satisfies) {
		this.satisfies = satisfies;
	}


	@OslcDescription("The Requirement decomposed by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_DECOMPOSED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("decomposedBy")
	public List<AbstractResource> getDecomposedBy() {
		return decomposedBy;
	}


	public void setDecomposedBy(List<AbstractResource> decomposedBy) {
		this.decomposedBy = decomposedBy;
	}


	@OslcDescription("The Requirement decomposes.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_DECOMPOSES)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("decomposes")
	public List<AbstractResource> getDecomposes() {
		return decomposes;
	}


	public void setDecomposes(List<AbstractResource> decomposes) {
		this.decomposes = decomposes;
	}


	@OslcDescription("The Requirement constrained by.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_CONSTRAINED_BY)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("constrainedBy")
	public List<AbstractResource> getConstrainedBy() {
		return constrainedBy;
	}


	public void setConstrainedBy(List<AbstractResource> constrainedBy) {
		this.constrainedBy = constrainedBy;
	}


	@OslcDescription("The Requirement constraints.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_CONSTRAINTS)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("constraints")
	public List<AbstractResource> getConstraints() {
		return constraints;
	}


	public void setConstraints(List<AbstractResource> constraints) {
		this.constraints = constraints;
	}


	@OslcDescription("The Requirement uses.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcPropertyDefinition(Constants.OSLC_RM_USES)
	@OslcRepresentation(Representation.Inline)
	@OslcValueType(ValueType.Resource)
	@OslcTitle("uses")
	public List<AbstractResource> getUses() {
		return uses;
	}


	public void setUses(List<AbstractResource> uses) {
		this.uses = uses;
	}



}
