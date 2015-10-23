package solutions.egen.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//Other requests (for HTML, CSS, etc) should be handled by Tomcat, not Jersey
@ApplicationPath("/api")
public class RESTAppConfig extends ResourceConfig {

	public RESTAppConfig(){
		//package containing Controller classes
		packages("solutions.egen.rest");
	}
}
