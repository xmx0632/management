package org.xmx0632.management.api.v1.bo;

public class AllFruitCategoryRequest {

	private String terminalType;

	@Override
	public String toString() {
		return "AllFruitCategoryRequest [terminalType=" + terminalType + "]";
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

}
