package org.xmx0632.management.api.v1.bo;

import java.util.Map;

public class UpdateResponse {

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
		return "UpdateResponse [result=" + result + ", err=" + err + "]";
	}

	public static UpdateResponse createFailResponse(String msg) {
		UpdateResponse updateResponse = new UpdateResponse();
		updateResponse.setResult(new Result(Result.FAIL, msg));
		return updateResponse;
	}
}
