package fr.friquerette.gradlews.rt.service;

import fr.friquerette.gradlews.rt.api.DefaultApi20;
import fr.friquerette.gradlews.rt.model.OAuthConfig;
import fr.friquerette.gradlews.rt.model.OAuthConstants;
import fr.friquerette.gradlews.rt.model.OAuthRequest;
import fr.friquerette.gradlews.rt.model.Response;
import fr.friquerette.gradlews.rt.model.Token;
import fr.friquerette.gradlews.rt.model.Verifier;

public class OAuth20ServiceImpl implements OAuthService {
	private static final String VERSION = "2.0";

	private final DefaultApi20 api;
	private final OAuthConfig config;

	/**
	 * Default constructor
	 * 
	 * @param api
	 *            OAuth2.0 api information
	 * @param config
	 *            OAuth 2.0 configuration param object
	 */
	public OAuth20ServiceImpl(DefaultApi20 api, OAuthConfig config) {
		this.api = api;
		this.config = config;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Token getAccessToken(Token requestToken, Verifier verifier) {
		OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
		request.addQuerystringParameter(OAuthConstants.CLIENT_ID, config.getApiKey());
		request.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
		request.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue());
		request.addQuerystringParameter(OAuthConstants.REDIRECT_URI, config.getCallback());
		if (config.hasScope())
			request.addQuerystringParameter(OAuthConstants.SCOPE, config.getScope());
		Response response = request.send();
		return api.getAccessTokenExtractor().extract(response.getBody());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Token getRequestToken() {
		throw new UnsupportedOperationException(
				"Unsupported operation, please use 'getAuthorizationUrl' and redirect your users there");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getVersion() {
		return VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void signRequest(Token accessToken, OAuthRequest request) {
		request.addQuerystringParameter(OAuthConstants.ACCESS_TOKEN, accessToken.getToken());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return api.getAuthorizationUrl(config);
	}

}