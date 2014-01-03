package es.uc3m.inf.kr.rm.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import es.uc3m.inf.kr.common.utils.ApplicationContextLocator;
import es.uc3m.inf.kr.km.appserv.KnowledgeManagementAppServ;
import es.uc3m.inf.kr.pscs.to.GraphTO;

@Path("/graph")
public class GraphServiceRest {

	KnowledgeManagementAppServ appServ;

	public GraphServiceRest(){
		super();
		appServ = (KnowledgeManagementAppServ) ApplicationContextLocator.
				getApplicationContext().getBean(KnowledgeManagementAppServ.class.getSimpleName());
	}
				
	@GET
	@Produces({"text/plain", "application/xml", "application/json"})
	public GraphTO draw(@QueryParam("uri") String uri ){
		return this.appServ.createGraph(uri);	
	}
}
