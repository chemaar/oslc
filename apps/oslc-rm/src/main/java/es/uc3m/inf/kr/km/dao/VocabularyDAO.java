package es.uc3m.inf.kr.km.dao;

import java.net.URISyntaxException;
import java.util.List;

import es.uc3m.inf.kr.oslcrm.to.VocabularyTO;

public interface VocabularyDAO {
	public List<VocabularyTO> getTerms() throws URISyntaxException;

	public VocabularyTO getVocabularyElement(String conceptId);
}
