package org.xmx0632.management.api.v1.bo;

public class FruitCategoryBo {

	private String fruitCategoryId;
	private String name;
	private String iconUrl;

	@Override
	public String toString() {
		return "FruitCategoryBo [fruitCategoryId=" + fruitCategoryId
				+ ", name=" + name + ", iconUrl=" + iconUrl + "]";
	}

	public String getFruitCategoryId() {
		return fruitCategoryId;
	}

	public void setFruitCategoryId(String fruitCategoryId) {
		this.fruitCategoryId = fruitCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

}
