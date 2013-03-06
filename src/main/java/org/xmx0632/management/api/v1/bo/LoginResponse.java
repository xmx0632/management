package org.xmx0632.management.api.v1.bo;

public class LoginResponse {

	private Result result;

	private MobileUser user = null;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public MobileUser getUser() {
		return user;
	}

	public void setUser(MobileUser userAccount) {
		this.user = userAccount;
	}

	@Override
	public String toString() {
		return "LoginResponse [result=" + result + ", user=" + user + "]";
	}

	public static LoginResponse createLoginErrorResponse(String msg) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResult(new Result(Result.FAIL, msg));
		return loginResponse;
	}

}