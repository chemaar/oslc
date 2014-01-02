package es.uc3m.inf.kr.km.dao;

import es.uc3m.inf.kr.common.exceptions.KRModelException;
import es.uc3m.inf.kr.common.loader.KRModelWrapper;
import es.uc3m.inf.kr.common.loader.resources.ResourceLoader;

public interface KnowledgeManagementDAO {

	public KRModelWrapper load(ResourceLoader loader) throws KRModelException;

	public KRModelWrapper getModel();

}
