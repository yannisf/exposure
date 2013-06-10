package fragsoft.exposure.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/person")
public class ApplicationInfoResource {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationInfoResource.class);

	@GET
	@Produces("application/json")
	@Path(value="/{id}")
	public Person getPerson(@PathParam("id") Long id) {
		log.debug("GET Request [id:{}]", id);
		return new Person(id, "Yannis", "F.");
	}
	
	@POST
	@Consumes("application/json")
	public void submitPerson(Person person) {
		log.debug("POST Request [{}]", person);
	}
	
}