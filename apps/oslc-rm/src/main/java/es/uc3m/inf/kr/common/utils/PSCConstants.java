/**
 * (c) Copyright 2011 WESO, Computer Science Department,
 * Facultad de Ciencias, University of Oviedo, Oviedo, Asturias, Spain, 33007
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package es.uc3m.inf.kr.common.utils;


public class PSCConstants {

	public static final String HTTP_NUTS_PSI_ENAKTING_ORG_ID = "http://nuts.psi.enakting.org/id/";
	//FIXME: Change # by /
	public static final String HTTP_WWW_W3_ORG_2008_05_SKOS_XL = "http://www.w3.org/2008/05/skos-xl#";
	public static final String HTTP_WWW_W3_ORG_2004_02_SKOS_CORE = "http://www.w3.org/2004/02/skos/core#";

	
	public static final String SKOS_prefLabel = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"prefLabel";
	public static final String SKOS_example = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"example";
	public static final String SKOS_Concept = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"Concept";
	public static final String SKOS_Broader = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"broader";
	public static final String SKOS_Broader_Transitive = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"broaderTransitive";
	public static final String SKOS_IN_SCHEME = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"inScheme";
	public static final String SKOS_CLOSE_MATCH = HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"closeMatch";
	public static final String SKOS_EXACT_MATCH= HTTP_WWW_W3_ORG_2004_02_SKOS_CORE+"exactMatch";



	public static final String HTTP_PURL_ORG_WESO_PSCS = "http://purl.org/weso/pscs/";
	public static final String HTTP_PURL_ORG_WESO_PSCS_DEF_LEVEL = "http://purl.org/weso/pscs/ontology/level";
	public static final String HTTP_PURL_ORG_WESO_PSCS_DEF_RELATED_MATCH = "http://purl.org/weso/pscs/ontology/relatedMatch";
	public static final String HTTP_PURL_ORG_WESO_CPV_2008 = HTTP_PURL_ORG_WESO_PSCS+"cpv/2008/";
	public static final String HTTP_PURL_ORG_WESO_CPV_DEF = HTTP_PURL_ORG_WESO_PSCS+"cpv/ontology/";
	public static final String HTTP_PURL_ORG_WESO_CPV_2003 = HTTP_PURL_ORG_WESO_PSCS+"cpv/2003/";
	public static final String CPV2003_codeIn = HTTP_PURL_ORG_WESO_CPV_DEF+"codeIn2003";
	public static final String CPV_codeIn = HTTP_PURL_ORG_WESO_CPV_DEF+"codeIn";
	
	public static final String HTTP_PURL_ORG_WESO_CPV_DEF_DIVISION = HTTP_PURL_ORG_WESO_PSCS+"cpv/ontology/Division";
	public static final String HTTP_PURL_ORG_WESO_CPV_DEF_GROUP = HTTP_PURL_ORG_WESO_PSCS+"cpv/ontology/Group";
	public static final String HTTP_PURL_ORG_WESO_CPV_DEF_CLASS = HTTP_PURL_ORG_WESO_PSCS+"cpv/ontology/Class";
	public static final String HTTP_PURL_ORG_WESO_CPV_DEF_CATEGORY = HTTP_PURL_ORG_WESO_PSCS+"cpv/ontology/Category";
	
	public static final String CPV_CONCEPT = HTTP_PURL_ORG_WESO_CPV_DEF+"cpvConcept";
	
	public static final String HTTP_PURL_ORG_WESO_PPN_DEF = "http://purl.org/weso/ppn/def";
	public static final String HTTP_PURL_ORG_WESO_PPN = "http://purl.org/weso/ppn";
	public static final String CPV2008_codeIn = PSCConstants.HTTP_PURL_ORG_WESO_CPV_DEF+"codeIn2008";	
	public static final String NUTS_CODE = HTTP_PURL_ORG_WESO_PPN_DEF+"nutsCode";
	
	
	public static String formatNUTSTO(String id){	
		return HTTP_NUTS_PSI_ENAKTING_ORG_ID + id ;
	}
	 
	//2   f(Id)=Skos-Uri
	public static final String formatId2003(String id){
		return HTTP_PURL_ORG_WESO_CPV_2003 +"resource/"+ id;
	}
	

	//3   f(Id)=Skos-Uri
	public static String formatId(String id){	
		return HTTP_PURL_ORG_WESO_CPV_2008 +"resource/"+ id ;
	}
	

	public static String formatURIId(String id, String date) {
		//FIXME
		return PSCConstants.HTTP_PURL_ORG_WESO_PPN+"/"+date+"/"+id;
	}

}
