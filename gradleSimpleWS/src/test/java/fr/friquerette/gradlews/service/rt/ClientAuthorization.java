package fr.friquerette.gradlews.service.rt;

import static fr.friquerette.gradlews.service.rt.Constante.CLIENT_ID;
import static fr.friquerette.gradlews.service.rt.Constante.END_POINT_AUTHORIZATION;
import static fr.friquerette.gradlews.service.rt.Constante.REDIRECT_URI;
import static fr.friquerette.gradlews.service.rt.Constante.UTF_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;

public class ClientAuthorization {
	public static void main(String... arg) throws Exception {
		methodPost();
	}

	public final static void methodPost() throws Exception {
		BasicHttpParams httpParams = new BasicHttpParams();
		httpParams.setParameter(AuthPNames.CREDENTIAL_CHARSET, UTF_8);
		DefaultHttpClient client = new DefaultHttpClient(httpParams);
		HttpPost post = new HttpPost(END_POINT_AUTHORIZATION);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
		urlParameters.add(new BasicNameValuePair("scope", "https://www.googleapis.com/auth/youtube"));
		urlParameters.add(new BasicNameValuePair("redirect_uri", REDIRECT_URI));
		urlParameters.add(new BasicNameValuePair("response_type", "code"));
		urlParameters.add(new BasicNameValuePair("approval_prompt", "force"));
		urlParameters.add(new BasicNameValuePair("access_type", "offline"));
		// urlParameters.add(new BasicNameValuePair("state", "security_token"));
		// urlParameters.add(new BasicNameValuePair("include_granted_scopes",
		// "true"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}

	}

}
