package fr.friquerette.gradlews.rt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;

@Path("/resource")
public class ResourceEndpoint {
	// @Inject
	// private Database database;

	@GET
	@Produces("text/html")
	public Response get(@Context HttpServletRequest request) throws OAuthSystemException {
		String accessToken = null;
		try {
			// Make the OAuth Request out of this request
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);
			// Get the access token
			accessToken = oauthRequest.getAccessToken();

			// Validate the access token
			boolean invalid = false;
			if (invalid/* !database.isValidToken(accessToken) */) {
				// Return the OAuth error message
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.setRealm(Common.RESOURCE_SERVER_NAME).setError(OAuthError.ResourceResponse.INVALID_TOKEN)
						.buildHeaderMessage();

				// return Response.status(Response.Status.UNAUTHORIZED).build();
				return Response.status(Response.Status.UNAUTHORIZED).header(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE)).build();

			}
			// [1]
		} catch (OAuthProblemException e) {
			// Check if the error code has been set
			// Build error response....
		}
		return Response.status(Response.Status.OK).entity(accessToken).build();
	}
}