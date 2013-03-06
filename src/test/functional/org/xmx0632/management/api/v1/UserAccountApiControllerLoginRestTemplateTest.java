package org.xmx0632.management.api.v1;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.xmx0632.management.api.v1.bo.LoginRequest;
import org.xmx0632.management.api.v1.bo.LoginResponse;
import org.xmx0632.management.functional.BaseControllerTestCase;

public class UserAccountApiControllerLoginRestTemplateTest extends
		BaseControllerTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private static String url;

	@BeforeClass
	public static void initUrl() {
		url = baseUrl + "/user/login";
	}

	@Test
	public void testLoginSuccess() throws Exception {
		HttpHeaders requestHeaders = createHttpHeader("user3", "password");

		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setLoginName("user3");

		HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(
				loginRequest, requestHeaders);

		LoginResponse response = restTemplate.postForObject(url, entity,
				LoginResponse.class);

		String expected = "LoginResponse [result=Result [msg=, value=0], user=UserAccountDTO [customerId=3, customerName=user3, sex=0, mobile=13800138003, email=user3@gmail.com, username=user3, credit=0]]";
		assertEquals(expected, response.toString());

		formatHttpInfoPrint(HttpMethod.POST, url, requestHeaders,
				"合法的用户登录(英文登录名)", jsonMapper.toJson(loginRequest),
				jsonMapper.toJson(response));
	}

	@Test
	public void testLoginWithChineseFail() throws Exception {

		LoginRequest loginRequest = new LoginRequest();
		HttpHeaders requestHeaders = createHttpHeader("notExistUser",
				"password");
		try {

			loginRequest.setLoginName("notExistUser");

			HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(
					loginRequest, requestHeaders);

			restTemplate.postForObject(url, entity, LoginResponse.class);
		} catch (Exception e) {
			formatHttpInfoPrint(HttpMethod.POST, url, requestHeaders,
					"不存在的用户登录", jsonMapper.toJson(loginRequest), e.getMessage());
		}
	}

	@Test
	public void testLoginWithChineseSuccess() throws Exception {
		HttpHeaders requestHeaders = createHttpHeader("用户4", "password");

		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setLoginName("用户4");

		HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(
				loginRequest, requestHeaders);

		LoginResponse response = restTemplate.postForObject(url, entity,
				LoginResponse.class);

		String expected = "LoginResponse [result=Result [msg=, value=0], user=UserAccountDTO [customerId=4, customerName=用户3, sex=0, mobile=13800138004, email=user4@gmail.com, username=用户4, credit=0]]";
		assertEquals(expected, response.toString());
		formatHttpInfoPrint(HttpMethod.POST, url, requestHeaders,
				"合法的用户登录(中文登录名)", jsonMapper.toJson(loginRequest),
				jsonMapper.toJson(response));
	}

	@Test
	public void testLoginWithBannedAccount() throws Exception {

		LoginRequest loginRequest = new LoginRequest();
		HttpHeaders requestHeaders = createHttpHeader("bannedUser", "password");
		try {
			loginRequest.setLoginName("bannedUser");

			HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(
					loginRequest, requestHeaders);
			restTemplate.postForObject(url, entity, LoginResponse.class);
		} catch (Exception e) {
			formatHttpInfoPrint(HttpMethod.POST, url, requestHeaders,
					"已冻结用户登录", jsonMapper.toJson(loginRequest), e.getMessage());
		}
	}
}
