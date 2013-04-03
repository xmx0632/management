package org.xmx0632.management.api.v1.bo;

public class Result {
	public static final String SUCCESS = "0";
	public static final String FAIL = "1";
	public static final String USERNAME_ALREADY_EXIST = "2";

	public static final String MSG_ERR_NO_ID = "No Id";
	public static final String MSG_ERR_NOT_VALID_ID = "Not a valid Id";
	public static final String MSG_ERR_NOT_EXIST = "Not exsit";
	public static final String MSG_ERR_STORY_NOT_ONLINE = "Fruit story is not online";

	private String msg;
	private String value;

	public Result() {
	}

	public Result(String value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String result) {
		this.value = result;
	}

	@Override
	public String toString() {
		return "Result [msg=" + msg + ", value=" + value + "]";
	}

}
