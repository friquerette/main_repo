package fr.friquerette.gradlews.rt;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.bson.Document;

import fr.friquerette.gradlews.dao.MongoDbDAO;
import fr.friquerette.gradlews.model.Person;

@Path("/mongoDB")
public class MongoDbRT {

	private static MongoDbDAO mongoDbDAO = null;

	/**
	 * @url "http://localhost:8080/gradleSimpleWS/rest/mongoDB/hello/"
	 * 
	 * @return
	 */
	@GET
	@Path("/hello")
	@Produces("application/json")
	public String getMsg() {
		return "hello";

	}

	/**
	 * @url "http://localhost:8080/gradleSimpleWS/rest/mongoDB/person/paul/mathieu"
	 * 
	 * @return
	 */
	@GET
	@Path("/person/{firstName}/{lastName}")
	@Produces("application/json")
	public String createPerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		getMongoDbDAO().addPersonne(person);
		return "createPerson";

	}

	/**
	 * @url "http://localhost:8080/gradleSimpleWS/rest/mongoDB/all"
	 * 
	 * @return
	 */
	@GET
	@Path("/person/all")
	@Produces("application/json")
	public List<Document> getAll() {

		return getMongoDbDAO().findAllPersonne();

	}

	private MongoDbDAO getMongoDbDAO() {
		if (mongoDbDAO == null) {
			mongoDbDAO = new MongoDbDAO();
		}
		return mongoDbDAO;
	}
}
