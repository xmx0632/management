package org.xmx0632.management.api.v1.bo;

public class AllFruiStoriesRequest {

	private String terminalType;

	@Override
	public String toString() {
		return "AllFruiStoriesRequest [terminalType=" + terminalType + "]";
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

}
