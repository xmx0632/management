package org.xmx0632.management.api.v1.bo;

public enum TerminalType {

	IOS_NORMAL("ios_normal", 320, 480, 150, 150), IOS_RETINA("ios_retina", 640,
			960, 300, 300);

	private String value;
	private int picWidth;
	private int picHeight;

	private int iconWidth;
	private int iconHeight;

	public int getPicWidth() {
		return picWidth;
	}

	public int getPicHeight() {
		return picHeight;
	}

	public int getIconWidth() {
		return iconWidth;
	}

	public int getIconHeight() {
		return iconHeight;
	}

	TerminalType(String typeValue, int picWidth, int picHeight, int iconWidth,
			int iconHeight) {
		value = typeValue;
		this.picWidth = picWidth;
		this.picHeight = picHeight;
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;

	}

	public String toConfigName() {
		return value + "_dir";
	}

	public static TerminalType toType(String typeString) {
		for (TerminalType type : TerminalType.values()) {
			if (type.name().equalsIgnoreCase(typeString)) {
				return type;
			}
		}

		return null;
	}

	public static String printAllTypes() {
		String types = "";
		for (TerminalType type : TerminalType.values()) {
			types += type + ",";
		}
		if (types.endsWith(",")) {
			types = types.substring(0, types.length() - 1);
		}
		return types;
	}

}
