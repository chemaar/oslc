package es.uc3m.inf.kr.oslcrm;

import org.eclipse.lyo.oslc4j.core.model.OslcConstants;

import com.hp.hpl.jena.sparql.vocabulary.FOAF;

public interface Constants{
	public static String REQUIREMENTS_MANAGEMENT_DOMAIN                    = "http://open-services.net/ns/rm#";
    public static String REQUIREMENTS_MANAGEMENT_NAMESPACE           = "http://open-services.net/ns/rm#";
    public static String REQUIREMENTS_MANAGEMENT_PREFIX              = "oslc_rm";
    
    public static String QUALITY_MANAGEMENT_DOMAIN                    = "http://open-services.net/ns/qm#";
    public static String QUALITY_MANAGEMENT_NAMESPACE           = "http://open-services.net/ns/qm#";
    public static String QUALITY_MANAGEMENT_PREFIX              = "oslc_qm";
    
    public static String SOFTWARE_CONFIGURATION_MANAGEMENT_NAMESPACE = "http://open-services.net/ns/scm#";
    public static String SOFTWARE_CONFIGURATION_MANAGEMENT_PREFIX    = "oslc_scm";
    public static String BUGZILLA_DOMAIN							 = "http://www.bugzilla.org/rdf#"; 
    public static String BUGZILLA_NAMESPACE							 = "http://www.bugzilla.org/rdf#";
    public static String BUGZILLA_NAMESPACE_PREFIX					 = "bugz";
    
    public static String TRC_NAMESPACE					 = "http://thereusecompany.com/ontology/";
    

    public static String REQUIREMENT_REQUEST             = "RequirementManagement";
    public static String TYPE_REQUIREMENT_REQUEST        = REQUIREMENTS_MANAGEMENT_NAMESPACE + REQUIREMENT_REQUEST;
    public static String TYPE_CHANGE_SET            = SOFTWARE_CONFIGURATION_MANAGEMENT_NAMESPACE + "ChangeSet";
    public static String TYPE_DISCUSSION            = OslcConstants.OSLC_CORE_NAMESPACE + "Discussion";
  
    /*FOAF Properties*/
    public static String FOAF_NAMESPACE                = "http://xmlns.com/foaf/0.1/";
    public static String FOAF_PERSON                =     FOAF_NAMESPACE+"Person";
    public static String FOAF_NAME_PROPERTY               = FOAF_NAMESPACE+"name";
    public static String FOAF_MBOX_PROPERTY               = FOAF_NAMESPACE+"mbox";

    public static String TYPE_REQUIREMENT           = REQUIREMENTS_MANAGEMENT_NAMESPACE + "Requirement";
    
    public static String TYPE_TEST_CASE             = QUALITY_MANAGEMENT_NAMESPACE + "TestCase";
    public static String TYPE_TEST_EXECUTION_RECORD = QUALITY_MANAGEMENT_NAMESPACE + "TestExecutionRecord";
    public static String TYPE_TEST_PLAN             = QUALITY_MANAGEMENT_NAMESPACE + "TestPlan";
    public static String TYPE_TEST_RESULT           = QUALITY_MANAGEMENT_NAMESPACE + "TestResult";
    public static String TYPE_TEST_SCRIPT           = QUALITY_MANAGEMENT_NAMESPACE + "TestScript";

    public static String PATH_VOCABULARY_REQUEST = "vocabularyRequest";

    public static String USAGE_LIST = REQUIREMENTS_MANAGEMENT_NAMESPACE + "list";

    
    public static final String HDR_OSLC_VERSION = "OSLC-Core-Version";
    
    public static final String NEXT_PAGE = "org.eclipse.lyo.oslc4j.bugzilla.NextPage";
    
    /**Dublin Core**/
    
    public static final String DCTERMS = "http://purl.org/dc/terms/";
    public static final String DCTERMS_TITLE = "http://purl.org/dc/terms/title";
    /**OSLC Core**/
    
    /**OSLC RM**/
    

}