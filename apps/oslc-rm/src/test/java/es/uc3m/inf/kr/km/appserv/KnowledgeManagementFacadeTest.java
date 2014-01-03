package es.uc3m.inf.kr.km.appserv;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import es.uc3m.inf.kr.common.loader.JenaOWLModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.FilesResourceLoader;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;
import es.uc3m.inf.kr.common.utils.ApplicationContextLocator;
import es.uc3m.inf.kr.km.dao.FileKnowledgeManagementDAOImpl;
import es.uc3m.inf.kr.km.dao.KnowledgeManagementDAO;

public class KnowledgeManagementFacadeTest {

	@Test
	public void test() throws FileNotFoundException {
		ResourceLoader loader = new FilesResourceLoader(new String[]{"data/car-example-skos.ttl"});
		JenaOWLModelWrapper rdfModel = new JenaOWLModelWrapper(loader,"TURTLE");
		KnowledgeManagementDAO dao = new FileKnowledgeManagementDAOImpl(rdfModel);
		KnowledgeManagementFacade facade = new KnowledgeManagementFacade(dao);

	}

	@Test
	public void testCreateGraph() throws FileNotFoundException {
		ResourceLoader loader = new FilesResourceLoader(new String[]{"data/car-example-skos.ttl"});
		JenaOWLModelWrapper rdfModel = new JenaOWLModelWrapper(loader,"TURTLE");
		KnowledgeManagementDAO dao = new FileKnowledgeManagementDAOImpl(rdfModel);
		KnowledgeManagementFacade facade = new KnowledgeManagementFacade(dao);
		String uri= "http://threusecompany/km/demo/1381307095/car";
		System.out.println(facade.createGraph(uri));
	}

	
	
}
