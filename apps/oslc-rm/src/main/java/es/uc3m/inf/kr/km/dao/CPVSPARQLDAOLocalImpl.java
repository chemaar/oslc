package es.uc3m.inf.kr.km.dao;

import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;

import es.uc3m.inf.kr.common.loader.JenaRDFModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.FilesResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.oslcrm.to.VocabularyTO;

public class CPVSPARQLDAOLocalImpl implements VocabularyDAO {

	Model model;

	public CPVSPARQLDAOLocalImpl(){
		ResourceLoader loader = new FilesResourceLoader(new String[]{"cpv/cpv-2008.ttl"});
		JenaRDFModelWrapper rdfModel = new JenaRDFModelWrapper(loader,"TURTLE");
		this.model = (Model) rdfModel.getModel();	

	}

	public List<VocabularyTO> getTerms() throws URISyntaxException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public VocabularyTO getVocabularyElement(String conceptId) {
//		String query = //DAOSPARQLService.NS+" " + 
//				"SELECT * WHERE{ " +
//				"?element dc:identifier ?id. " +
//				"?element ?p ?o. " +
//				"FILTER (str(?id) = \""+conceptId +"\")"+
//				"} " +
//				qExec = QueryExecutionFactory.sparqlService("", query);
//		ResultSet resultsSet = qExec.execSelect();
//		return processingResults(resultsSet);
		throw new UnsupportedOperationException("Not implemented yet");

	}
}
