package org.xmx0632.management.api.v1.bo;

public class PromotionRuleRequest {

	private String terminalType;

	@Override
	public String toString() {
		return "PromotionRuleRequest [terminalType=" + terminalType + "]";
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

}
