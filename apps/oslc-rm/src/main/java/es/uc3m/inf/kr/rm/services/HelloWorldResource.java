package es.uc3m.inf.kr.rm.services;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
@Produces({"application/json"})
public class HelloWorldResource {

//    @GET
//    public String getMessage() {
//        return "Hello World!";
//    }
//    
    @GET
    public List<String> helloWorlds() {
      return Arrays.asList(new String [] {"Hello Earth!" });
    }
  	
    
}