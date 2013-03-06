package org.xmx0632.management.api.v1.bo;

public class UserPointResponse {
	private Result result;
	private int point;

	@Override
	public String toString() {
		return "UserPointResponse [result=" + result + ", point=" + point + "]";
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
