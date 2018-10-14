package com.steem.muksihs.rest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.steem.muksihs.SteemObjectMapper;

public class RestClient {
	private static SteemObjectMapper _mapper;
	private static SteemObjectMapper mapper() {
		if (_mapper==null) {
			_mapper = new SteemObjectMapper();
		}
		return _mapper;
	}
	
	public static String post(String url, Object param) throws IOException {
		return post(url, mapper().writeValueAsString(param));
	}
	
	public static String post(String url, String param) throws IOException {
		HttpURLConnection urlConnection = null;
		try {
			byte[] postData;
			if (param != null) {
				postData = param.getBytes(StandardCharsets.UTF_8);
			} else {
				postData = new byte[0];
			}

			URL endpoint = new URL(url);
			urlConnection = (HttpURLConnection) endpoint.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			urlConnection.setRequestProperty("charset", "utf-8");
			urlConnection.setRequestProperty("Content-Length", Integer.toString(postData.length));
			try (OutputStream outputStream = urlConnection.getOutputStream()) {
				outputStream.write(postData);
			}
			try (InputStream inputStream = urlConnection.getInputStream()) {
				return getString(inputStream);
			}
		} catch (Exception e) {
			throw new IOException(e.getMessage() + " => " + url);
		} finally {
			urlConnection.disconnect();
		}
	}

	/**
	 * Copy {@link InputStream} into a {@link String}. See <a href=
	 * "https://stackoverflow.com/a/35446009/1341731">https://stackoverflow.com/a/35446009/1341731</a>
	 * for performance comparisons for various ways to do this.
	 * 
	 * @param inputStream
	 * @return The input stream concatenated into a String.
	 * @throws IOException
	 */
	protected static String getString(InputStream inputStream) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result = bis.read();
		while (result != -1) {
			buf.write((byte) result);
			result = bis.read();
		}
		return buf.toString(StandardCharsets.UTF_8.name());
	}
}
