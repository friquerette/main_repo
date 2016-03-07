package fr.derruette.gradlews.rt.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.derruette.gradlews.rt.model.OAuthException;
import fr.derruette.gradlews.rt.model.Token;
import fr.derruette.gradlews.rt.utils.Preconditions;

public class JsonTokenExtractor implements AccessTokenExtractor {
	private Pattern accessTokenPattern = Pattern.compile("\"access_token\":\\s*\"(\\S*?)\"");

	@Override
	public Token extract(String response) {
		Preconditions.checkEmptyString(response, "Cannot extract a token from a null or empty String");
		Matcher matcher = accessTokenPattern.matcher(response);
		if (matcher.find()) {
			return new Token(matcher.group(1), "", response);
		} else {
			throw new OAuthException("Cannot extract an access token. Response was: " + response);
		}
	}

}