package es.uc3m.inf.kr.oslcrm;

import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;

import com.hp.hpl.jena.sparql.vocabulary.FOAF;

public interface Constants{
	public static String REQUIREMENTS_MANAGEMENT_DOMAIN                    = "http://open-services.net/ns/rm#";
    public static String REQUIREMENTS_MANAGEMENT_NAMESPACE           = "http://open-services.net/ns/rm#";
    public static String REQUIREMENTS_MANAGEMENT_PREFIX              = "oslc_rm";
    
    public static String KM_NAMESPACE					 = "http://kr.inf.uc3m.es/ontology/";
    

    public static String REQUIREMENT_REQUEST             = "RequirementManagement";
    public static String TYPE_REQUIREMENT_REQUEST        = REQUIREMENTS_MANAGEMENT_NAMESPACE + REQUIREMENT_REQUEST;
  
    
    /*KM Properties*/
    
	public static String VOCABULARY_MANAGEMENT_DOMAIN                    = "http://kr.inf.uc3m.es/km/vocabulary/";
	public static String KNOWLEDGE_MANAGEMENT_DOMAIN                    = "http://kr.inf.uc3m.es/km/";
	public static String TYPE_KNOWLEDGE_ELEMENT       = KNOWLEDGE_MANAGEMENT_DOMAIN + "Resource";
    
    public static String KM_LEVEL                =     KM_NAMESPACE+"level";
    public static String KM_TYPE_SYSTEM                =     KM_NAMESPACE+"System";
    public static String KM_TYPE_COMPONENT              =     KM_NAMESPACE+"Component";
    public static String KM_TYPE_VOCABULARY_ELEMENT              =     KM_NAMESPACE+"KnowledgeElement";
    
    /*FOAF Properties*/
    public static String FOAF_NAMESPACE                = "http://xmlns.com/foaf/0.1/";
    public static String FOAF_PERSON                =     FOAF_NAMESPACE+"Person";
    public static String FOAF_NAME_PROPERTY               = FOAF_NAMESPACE+"name";
    public static String FOAF_MBOX_PROPERTY               = FOAF_NAMESPACE+"mbox";

    public static String PATH_VOCABULARY_REQUEST = "vocabularyRequest";

    public static String USAGE_LIST = REQUIREMENTS_MANAGEMENT_NAMESPACE + "list";

    
    public static final String HDR_OSLC_VERSION = "OSLC-Core-Version";
    
    public static final String NEXT_PAGE = "org.eclipse.lyo.oslc4j.bugzilla.NextPage";
    
    /**Dublin Core**/
    
    public static final String DCTERMS = OslcConstants.DCTERMS_NAMESPACE;
    public static final String DCTERMS_TITLE = DCTERMS+"title";
    public static final String DCTERMS_DESCRIPTION = DCTERMS+"description";
    public static final String DCTERMS_IDENTIFIER = DCTERMS+"identifier";
    public static final String DCTERMS_SUBJECT = DCTERMS+"subject";
    public static final String DCTERMS_CREATOR = DCTERMS+"creator";
    public static final String DCTERMS_CONTRIBUTOR = DCTERMS+"contributor";
    public static final String DCTERMS_CREATED = DCTERMS+"created";
    public static final String DCTERMS_MODIFIED = DCTERMS+"modified";

    /**OSLC Core**/
    public static final String OSLC_CORE = OslcConstants.OSLC_CORE_NAMESPACE_PREFIX;
    public static final String OSLC_CORE_SHORT_TITLE = OSLC_CORE+"shortTitle";
    /**OSLC RM**/
    
    public static final String OSLC_RM = REQUIREMENTS_MANAGEMENT_NAMESPACE;
    public static final String OSLC_RM_ELABORATED_BY = OSLC_RM+"elaboratedBy";
    public static final String OSLC_RM_ELABORATES = OSLC_RM+"elaborates";
    public static final String OSLC_RM_SPECIFIED_BY= OSLC_RM+"specifiedBy";
    public static final String OSLC_RM_SPECIFIES= OSLC_RM+"specifies";
    public static final String OSLC_RM_AFFECTED_BY= OSLC_RM+"affectedBy";
    public static final String OSLC_RM_TRACKED_BY= OSLC_RM+"trackedBy";
    public static final String OSLC_RM_IMPLEMENTED_BY= OSLC_RM+"implementedBy";
    public static final String OSLC_RM_VALIDATED_BY= OSLC_RM+"validatedBy";
    public static final String OSLC_RM_SATISFIED_BY= OSLC_RM+"satisfiedBy";
    public static final String OSLC_RM_SATISFIES= OSLC_RM+"satisfies";
    public static final String OSLC_RM_DECOMPOSED_BY= OSLC_RM+"decomposedBy";
    public static final String OSLC_RM_DECOMPOSES= OSLC_RM+"decomposes";
    public static final String OSLC_RM_CONSTRAINED_BY= OSLC_RM+"constrainedBy";
    public static final String OSLC_RM_CONSTRAINTS= OSLC_RM+"constraints";
    public static final String OSLC_RM_USES= OSLC_RM+"uses";

}