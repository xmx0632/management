package org.xmx0632.management.api.v1.bo;

import java.util.Map;

public class RegisterResponse {

	private Result result;
	private Map<String, String> err;

	public Map<String, String> getErr() {
		return err;
	}

	public void setErr(Map<String, String> info) {
		this.err = info;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "RegisterResponse [result=" + result + ", err=" + err + "]";
	}

	public static RegisterResponse createFailResponse(String msg) {
		RegisterResponse updateResponse = new RegisterResponse();
		updateResponse.setResult(new Result(Result.FAIL, msg));
		return updateResponse;
	}

	public static RegisterResponse createUsernameExistResponse(String msg) {
		RegisterResponse updateResponse = new RegisterResponse();
		updateResponse
				.setResult(new Result(Result.USERNAME_ALREADY_EXIST, msg));
		return updateResponse;
	}
}
