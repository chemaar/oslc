package es.uc3m.inf.kr.oslcrm.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public String getMessage() {
        return "Hello World!";
    }
}