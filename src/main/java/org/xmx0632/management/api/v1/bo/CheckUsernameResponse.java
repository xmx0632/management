package org.xmx0632.management.api.v1.bo;

public class CheckUsernameResponse {

	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CheckUsernameResponse [result=" + result + "]";
	}

	public static CheckUsernameResponse createResponse(String rzlt, String msg) {
		CheckUsernameResponse response = new CheckUsernameResponse();
		response.setResult(new Result(rzlt, msg));
		return response;
	}

}