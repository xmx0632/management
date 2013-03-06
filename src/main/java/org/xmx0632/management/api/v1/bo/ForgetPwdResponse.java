package org.xmx0632.management.api.v1.bo;

public class ForgetPwdResponse {

	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ForgetPwdResponse [result=" + result + "]";
	}

	public static ForgetPwdResponse createResponse(String rzlt, String msg) {
		ForgetPwdResponse response = new ForgetPwdResponse();
		response.setResult(new Result(rzlt, msg));
		return response;
	}

}