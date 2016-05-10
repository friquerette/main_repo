package fr.friquerette.gradlews.service.rt;

import static fr.friquerette.gradlews.model.Common.CLIENT_ID;
import static fr.friquerette.gradlews.model.Common.CLIENT_SECRET;
import static fr.friquerette.gradlews.model.Common.CODE;
import static fr.friquerette.gradlews.model.Common.END_POINT_TOKEN;
import static fr.friquerette.gradlews.model.Common.REDIRECT_URI;
import static fr.friquerette.gradlews.model.Common.UTF_8;

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

public class ClientCode {
	public static void main(String... arg) throws Exception {
		methodPost();
	}

	public final static void methodPost() throws Exception {
		BasicHttpParams httpParams = new BasicHttpParams();
		httpParams.setParameter(AuthPNames.CREDENTIAL_CHARSET, UTF_8);
		DefaultHttpClient client = new DefaultHttpClient(httpParams);
		HttpPost post = new HttpPost(END_POINT_TOKEN);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("code", CODE));
		urlParameters.add(new BasicNameValuePair("redirect_uri", REDIRECT_URI));
		urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
		urlParameters.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
		urlParameters.add(new BasicNameValuePair("scope", ""));
		urlParameters.add(new BasicNameValuePair("grant_type", "authorization_code"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}

	}

}
