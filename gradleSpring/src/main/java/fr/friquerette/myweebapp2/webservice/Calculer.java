package fr.friquerette.myweebapp2.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//@WebService
@Path("/hello")
public class Calculer {

	@GET
	@Path("/{param}")
	public long additionner(int valeur1, int valeur2) {
		return valeur1 + valeur2;
	}

}
