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
public class ManagedVocabularyTO extends AbstractResource{
/**
 * <http://threusecompany/km/taxonomy/demo/1381307095/c1>
      a   skos:Concept ;
      #1-Authoring properties
      dcterms:author  km-people:JM;
      dcterms:created "2013-10-10"^^xsd:date ;
      dcterms:modified "2013-10-10"^^xsd:date ;
      #2-Lexical labels
      rdfs:label "zonas"@ES;
      rdfs:label "areas"@EN;
      skos:prefLabel "zonas"@ES;
      skos:prefLabel "areas"@EN;   
      skos:altLabel "superficie"@ES;
      skos:altLabel "zones"@EN; 
      #3-Documentation properties
      skos:changeNote "An example of change note."@EN;
      skos:editorialNote "An example of editorial note"@EN;
      skos:historyNote "An example of history note"@EN;
      skos:scopeNote "An example of scope note"@EN;
      #4-Notation
      skos:notation "c1"^^xsd:string ;
      dcterms:subject "1"^^xsd:string ;
      km:level "1"; 
      #5-Semantic and hierarchy properties
      #sym property skos:related <>; 
      #km:related <>;
      skos:narrower 
	<http://threusecompany/km/taxonomy/demo/1381307095/c11>,
	<http://threusecompany/km/taxonomy/demo/1381307095/c12>,
	<http://threusecompany/km/taxonomy/demo/1381307095/c13>;
      #6-Mapping properties
      #skos:closeMatch <>;
      #7-Concept Scheme
      skos:inScheme <http://threusecompany/km/taxonomy/demo/ds> ;
      .
 */
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
