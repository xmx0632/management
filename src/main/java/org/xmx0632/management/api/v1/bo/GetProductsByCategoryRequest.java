package org.xmx0632.management.api.v1.bo;

public class GetProductsByCategoryRequest {

	private String fruitCategoryId;
	private String terminalType;

	@Override
	public String toString() {
		return "GetProductsByCategoryRequest [fruitCategoryId="
				+ fruitCategoryId + ", terminalType=" + terminalType + "]";
	}

	public String getFruitCategoryId() {
		return fruitCategoryId;
	}

	public void setFruitCategoryId(String fruitCategoryId) {
		this.fruitCategoryId = fruitCategoryId;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

}
