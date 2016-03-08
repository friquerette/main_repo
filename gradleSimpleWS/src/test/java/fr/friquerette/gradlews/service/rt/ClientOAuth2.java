package fr.friquerette.gradlews.service.rt;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class ClientOAuth2 {
	private final static String CLIENT_ID = "965757910464-i2k1ontnt3qi840q396j01lmf0bn9kiv.apps.googleusercontent.com";
	private final static String CLIENT_SECRET = "JteYBaHtvAvIPcmYnkiQeU-L";
	// host = applicationHost + "auth/google/callback"
	private final static String HOST = "http://localhost:8080/gradleWS/rest/token";

	public static void main(String... arg) throws OAuthSystemException {

	}

}
