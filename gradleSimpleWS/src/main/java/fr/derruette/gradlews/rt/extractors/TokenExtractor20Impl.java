package fr.derruette.gradlews.rt.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.derruette.gradlews.rt.model.OAuthException;
import fr.derruette.gradlews.rt.model.Token;
import fr.derruette.gradlews.rt.utils.OAuthEncoder;
import fr.derruette.gradlews.rt.utils.Preconditions;

/**
 * Default implementation of {@link AccessTokenExtractor}. Conforms to OAuth 2.0
 */
public class TokenExtractor20Impl implements AccessTokenExtractor {
	private static final String TOKEN_REGEX = "access_token=([^&]+)";
	private static final String EMPTY_SECRET = "";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Token extract(String response) {
		Preconditions.checkEmptyString(response,
				"Response body is incorrect. Can't extract a token from an empty string");

		Matcher matcher = Pattern.compile(TOKEN_REGEX).matcher(response);
		if (matcher.find()) {
			String token = OAuthEncoder.decode(matcher.group(1));
			return new Token(token, EMPTY_SECRET, response);
		} else {
			throw new OAuthException("Response body is incorrect. Can't extract a token from this: '" + response + "'",
					null);
		}
	}
}