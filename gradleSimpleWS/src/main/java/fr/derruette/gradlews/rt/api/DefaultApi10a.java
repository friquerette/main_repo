package fr.derruette.gradlews.rt.api;

import fr.derruette.gradlews.rt.extractors.AccessTokenExtractor;
import fr.derruette.gradlews.rt.extractors.BaseStringExtractor;
import fr.derruette.gradlews.rt.extractors.BaseStringExtractorImpl;
import fr.derruette.gradlews.rt.extractors.HeaderExtractor;
import fr.derruette.gradlews.rt.extractors.HeaderExtractorImpl;
import fr.derruette.gradlews.rt.extractors.RequestTokenExtractor;
import fr.derruette.gradlews.rt.extractors.TokenExtractorImpl;
import fr.derruette.gradlews.rt.model.OAuthConfig;
import fr.derruette.gradlews.rt.model.Token;
import fr.derruette.gradlews.rt.model.Verb;
import fr.derruette.gradlews.rt.service.HMACSha1SignatureService;
import fr.derruette.gradlews.rt.service.OAuth10aServiceImpl;
import fr.derruette.gradlews.rt.service.OAuthService;
import fr.derruette.gradlews.rt.service.SignatureService;
import fr.derruette.gradlews.rt.service.TimestampService;
import fr.derruette.gradlews.rt.service.TimestampServiceImpl;

/**
 * Default implementation of the OAuth protocol, version 1.0a
 * 
 * This class is meant to be extended by concrete implementations of the API,
 * providing the endpoints and endpoint-http-verbs.
 * 
 * If your Api adheres to the 1.0a protocol correctly, you just need to extend
 * this class and define the getters for your endpoints.
 * 
 * If your Api does something a bit different, you can override the different
 * extractors or services, in order to fine-tune the process. Please read the
 * javadocs of the interfaces to get an idea of what to do.
 * 
 * @author Pablo Fernandez
 * 
 */
public abstract class DefaultApi10a implements Api {
	/**
	 * Returns the access token extractor.
	 * 
	 * @return access token extractor
	 */
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new TokenExtractorImpl();
	}

	/**
	 * Returns the base string extractor.
	 * 
	 * @return base string extractor
	 */
	public BaseStringExtractor getBaseStringExtractor() {
		return new BaseStringExtractorImpl();
	}

	/**
	 * Returns the header extractor.
	 * 
	 * @return header extractor
	 */
	public HeaderExtractor getHeaderExtractor() {
		return new HeaderExtractorImpl();
	}

	/**
	 * Returns the request token extractor.
	 * 
	 * @return request token extractor
	 */
	public RequestTokenExtractor getRequestTokenExtractor() {
		return new TokenExtractorImpl();
	}

	/**
	 * Returns the signature service.
	 * 
	 * @return signature service
	 */
	public SignatureService getSignatureService() {
		return new HMACSha1SignatureService();
	}

	/**
	 * Returns the timestamp service.
	 * 
	 * @return timestamp service
	 */
	public TimestampService getTimestampService() {
		return new TimestampServiceImpl();
	}

	/**
	 * Returns the verb for the access token endpoint (defaults to POST)
	 * 
	 * @return access token endpoint verb
	 */
	public Verb getAccessTokenVerb() {
		return Verb.POST;
	}

	/**
	 * Returns the verb for the request token endpoint (defaults to POST)
	 * 
	 * @return request token endpoint verb
	 */
	public Verb getRequestTokenVerb() {
		return Verb.POST;
	}

	/**
	 * Returns the URL that receives the request token requests.
	 * 
	 * @return request token URL
	 */
	public abstract String getRequestTokenEndpoint();

	/**
	 * Returns the URL that receives the access token requests.
	 * 
	 * @return access token URL
	 */
	public abstract String getAccessTokenEndpoint();

	/**
	 * Returns the URL where you should redirect your users to authenticate your
	 * application.
	 * 
	 * @param requestToken
	 *            the request token you need to authorize
	 * @return the URL where you should redirect your users
	 */
	public abstract String getAuthorizationUrl(Token requestToken);

	/**
	 * Returns the {@link OAuthService} for this Api
	 * 
	 * @param apiKey
	 *            Key
	 * @param apiSecret
	 *            Api Secret
	 * @param callback
	 *            OAuth callback (either URL or 'oob')
	 * @param scope
	 *            OAuth scope (optional)
	 */
	@Override
	public OAuthService createService(OAuthConfig config) {
		return new OAuth10aServiceImpl(this, config);
	}
}