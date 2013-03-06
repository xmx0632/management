package org.xmx0632.management.global;

public enum ConfigConstant {
	PAGE_SIZE("每页显示记录数");

	private ConfigConstant(String desc) {
		this.description = desc;
	}

	private String description;

	public String getDescription() {
		return description;
	}

}
