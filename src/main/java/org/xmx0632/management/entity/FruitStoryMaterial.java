package org.xmx0632.management.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FruitStoryMaterial.
 */
@Entity
@Table(name = "tbl_fruit_story_material")
public class FruitStoryMaterial extends IdEntity {

	private String fruitName;
	private Integer fruitNum;
	private Integer seq;
	private FruitStoryMenu fruitStoryMenu;

	public FruitStoryMaterial() {
	}

	public String getFruitName() {
		return this.fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public Integer getFruitNum() {
		return this.fruitNum;
	}

	public void setFruitNum(Integer fruitNum) {
		this.fruitNum = fruitNum;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@ManyToOne
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
