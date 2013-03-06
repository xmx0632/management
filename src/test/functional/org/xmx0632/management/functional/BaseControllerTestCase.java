package org.xmx0632.management.functional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.utils.Encodes;
import org.xmx0632.management.api.v1.Constant;

public class BaseControllerTestCase {

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String UTF_8 = "utf-8";

	protected static String serviceUrl = "http://127.0.0.1:8888/management";

	protected static String baseUrl;

	protected static String pictureServerRootUrl = "http://localhost";

	protected JsonMapper jsonMapper = new JsonMapper();

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@BeforeClass
	public static void beforeClass() throws Exception {
		baseUrl = serviceUrl + "/api/v1";
	}

	protected HttpHeaders createHttpHeader(String username, String password)
			throws UnsupportedEncodingException {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		String auth = Encodes.encodeBase64(getUserPassword(username, password));
		requestHeaders.set(Constant.AUTH, auth);
		return requestHeaders;
	}

	protected String sendPostMsg(String username, String password,
			String message, String url) throws UnsupportedEncodingException,
			IOException, ClientProtocolException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		StringEntity myEntity = new StringEntity(message, UTF_8);
		String auth = Encodes.encodeBase64(getUserPassword(username, password));
		httppost.addHeader(Constant.AUTH, auth);
		httppost.addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		httppost.setEntity(myEntity);
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity resEntity = response.getEntity();
		String responseContent = "";
		if (resEntity != null) {
			responseContent = EntityUtils.toString(resEntity, "UTF-8");
			EntityUtils.consume(resEntity);
		}
		httpclient.getConnectionManager().shutdown();
		return responseContent;
	}

	private byte[] getUserPassword(String username, String password)
			throws UnsupportedEncodingException {
		return (username + ":" + password).getBytes(UTF_8);
	}

	protected void formatHttpInfoPrint(HttpMethod method, String url,
			HttpHeaders requestHeaders, String summary, String request,
			String response) {
		log.debug(
				"\n\n测试项:[{}]\nURL地址:[{}]\nHTTP方法:[{}]\nHTTP头:[{}]\n请求消息:[{}]\n响应消息:[{}]",
				summary, url, method, requestHeaders, request, response);

	}
}
