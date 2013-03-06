package org.xmx0632.management.api.v1.bo;

public class FruitStoryRequest {
	private String id;
	private String terminalType;

	@Override
	public String toString() {
		return "FruitStoryRequest [id=" + id + ", terminalType=" + terminalType
				+ "]";
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
