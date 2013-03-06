package org.xmx0632.management.api.v1.bo;

public class FruitStoryBo {

	protected Long id;

	private String name;
	private String introduction;
	private String pictureUrl;
	private String wmPictureUrl;
	private FruitStoryMenuBo fruitStoryMenu;

	public FruitStoryBo() {
	}

	public FruitStoryBo(Long id, String name, String introduction,
			String pictureUrl) {
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.pictureUrl = pictureUrl;
	}

	@Override
	public String toString() {
		return "FruitStoryBo [id=" + id + ", name=" + name + ", introduction="
				+ introduction + ", pictureUrl=" + pictureUrl
				+ ", wmPictureUrl=" + wmPictureUrl + ", fruitStoryMenu="
				+ fruitStoryMenu + "]";
	}

	public String getWmPictureUrl() {
		return wmPictureUrl;
	}

	public void setWmPictureUrl(String wmPictureUrl) {
		this.wmPictureUrl = wmPictureUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public FruitStoryMenuBo getFruitStoryMenu() {
		return fruitStoryMenu;
	}

	public void setFruitStoryMenu(FruitStoryMenuBo fruitStoryMenu) {
		this.fruitStoryMenu = fruitStoryMenu;
	}

}
