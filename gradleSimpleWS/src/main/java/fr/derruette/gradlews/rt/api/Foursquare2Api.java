package fr.derruette.gradlews.rt.api;

import fr.derruette.gradlews.rt.extractors.AccessTokenExtractor;
import fr.derruette.gradlews.rt.extractors.JsonTokenExtractor;
import fr.derruette.gradlews.rt.model.OAuthConfig;
import fr.derruette.gradlews.rt.utils.OAuthEncoder;
import fr.derruette.gradlews.rt.utils.Preconditions;

public class Foursquare2Api extends DefaultApi20 {
	private static final String AUTHORIZATION_URL = "https://foursquare.com/oauth2/authenticate?client_id=%s&response_type=code&redirect_uri=%s";

	@Override
	public String getAccessTokenEndpoint() {
		return "https://foursquare.com/oauth2/access_token?grant_type=authorization_code";
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		Preconditions.checkValidUrl(config.getCallback(),
				"Must provide a valid url as callback. Foursquare2 does not support OOB");
		return String.format(AUTHORIZATION_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new JsonTokenExtractor();
	}
}