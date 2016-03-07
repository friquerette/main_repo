package fr.derruette.gradlews.service.rt;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class ClientOAuth2 {
	private final static String CLIENT_ID = "965757910464-i2k1ontnt3qi840q396j01lmf0bn9kiv.apps.googleusercontent.com";
	private final static String CLIENT_SECRET = "JteYBaHtvAvIPcmYnkiQeU-L";
	// host = applicationHost + "auth/google/callback"
	private final static String HOST = "http://localhost:8080/gradleWS/rest/token";

	public static void main(String... arg) throws OAuthSystemException {

	}

	private static void method1() throws OAuthSystemException {
		OAuthClientRequest request = OAuthClientRequest.authorizationProvider(OAuthProviderType.GOOGLE)
				.setClientId(CLIENT_ID).setRedirectURI("http://www.example.com/redirect").buildQueryMessage();
		// request.getLocationUri();
		System.out.println(request);
	}

	private static void method2() throws OAuthSystemException {
		OAuthClientRequest oAuthClientRequest = OAuthClientRequest.authorizationProvider(OAuthProviderType.GOOGLE)
				.setResponseType("code").setClientId(CLIENT_ID).setParameter("access_type", "online")
				.setRedirectURI(HOST).setScope("https://www.googleapis.com/auth/plus.login").buildQueryMessage();
		oAuthClientRequest.getLocationUri();
		// response.sendRedirect(oAuthClientRequest.getLocationUri());
	}
}
