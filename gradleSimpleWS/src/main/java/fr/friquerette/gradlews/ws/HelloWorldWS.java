package fr.friquerette.gradlews.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWS {

	@WebMethod(operationName = "getHelloWorld")
	public String getHelloWorld(String name) {
		return "Hello World JAX-WS " + name;
	}

	@WebMethod(operationName = "add")
	public int add(int a, int b) {
		return a + b;
	}

}