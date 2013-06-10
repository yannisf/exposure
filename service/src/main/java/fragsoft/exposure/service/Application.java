package fragsoft.exposure.service;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("api")
public class Application extends PackagesResourceConfig {

	public Application() {
		super("fragsoft.exposure.service");
	}
	
}