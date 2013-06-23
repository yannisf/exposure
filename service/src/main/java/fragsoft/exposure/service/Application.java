package fragsoft.exposure.service;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class Application extends PackagesResourceConfig {

    public Application() {
        super("fragsoft.exposure.service");
        this.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    }

}