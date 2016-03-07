package fr.derruette.gradlews.rt.service;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import fr.derruette.gradlews.rt.model.OAuthException;

public class CommonsEncoder extends Base64Encoder {

	@Override
	public String encode(byte[] bytes) {
		try {
			return new String(Base64.encodeBase64(bytes), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new OAuthException("Can't perform base64 encoding", e);
		}
	}

	@Override
	public String getType() {
		return "CommonsCodec";
	}

	public static boolean isPresent() {
		try {
			Class.forName("org.apache.commons.codec.binary.Base64");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}