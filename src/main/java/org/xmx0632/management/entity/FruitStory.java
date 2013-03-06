package org.xmx0632.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FruitStory.
 */
@Entity
@Table(name = "tbl_fruit_story")
public class FruitStory extends IdEntity {

	public static final String STATUS_CREATING = "0";
	public static final String STATUS_ONLINE = "1";
	public static final String STATUS_OFFLINE = "2";

	private String name;
	private String pictureUrl;
	private String introduction;
	private String status;
	private Date createTime;
	private FruitStoryMenu fruitStoryMenu;

	public FruitStory() {
	}

	public FruitStory(String name, String pictureUrl, String status) {
		this.name = name;
		this.pictureUrl = pictureUrl;
		this.status = status;
	}

	@NotNull
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@NotNull
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "fruit_story_menu_id")
	public FruitStoryMenu getFruitStoryMenu() {
		return fruitStoryMenu;
	}

	public void setFruitStoryMenu(FruitStoryMenu fruitStoryMenu) {
		this.fruitStoryMenu = fruitStoryMenu;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
