package org.xmx0632.management.api.v1.bo;

import java.util.Map;

public class UpdatePwdResponse {

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
		return "UpdatePwdResponse [result=" + result + ", err=" + err + "]";
	}

	public static UpdatePwdResponse createFailResponse(String msg) {
		UpdatePwdResponse updateResponse = new UpdatePwdResponse();
		updateResponse.setResult(new Result(Result.FAIL, msg));
		return updateResponse;
	}
}
