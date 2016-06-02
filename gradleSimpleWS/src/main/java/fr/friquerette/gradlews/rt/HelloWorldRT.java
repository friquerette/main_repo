package fr.friquerette.gradlews.rt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.friquerette.gradlews.model.Track;

@Path("/helloRT")
public class HelloWorldRT {

	/**
	 * @url "http://localhost:8080/gradleSimpleWS/rest/helloRT/get/Muse/Drones"
	 * @param singer
	 * @param title
	 * @return
	 */
	@GET
	@Path("/get/{singer1}/{title1}")
	@Produces("application/json")
	public Track getMsg(@PathParam("singer1") String singer, @PathParam("title1") String title) {
		Track track = new Track();
		track.setSinger(singer);
		track.setTitle(title);
		return track;

	}

	/**
	 * @url "http://localhost:8080/gradleSimpleWS/rest/helloRT/hello/"
	 * 
	 * @return
	 */
	@GET
	@Path("/hello")
	@Produces("application/json")
	public String getMsg() {
		return "hello";

	}

	@POST
	@Path("/post")
	// Content-Type : application/json
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
		track.setSinger("toto");
		String result = "Track saved : " + track;
		return Response.status(201).entity(track).build();

	}
}