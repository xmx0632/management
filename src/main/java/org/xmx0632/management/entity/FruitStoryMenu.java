package org.xmx0632.management.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

/**
 * FruitStoryMenu.
 */
@Entity
@Table(name = "tbl_fruit_story_menu")
public class FruitStoryMenu extends IdEntity {

	private Long productId;
	private String fruitStoryPicUrl;
	private String fruitStoryIntro;
	private FruitStory fruitStory;

	private List<FruitStoryMaterial> fruitStoryMaterialList = Lists
			.newArrayList(); // 有序的关联对象集合
	private List<FruitStoryProcedure> fruitStoryProcedureList = Lists
			.newArrayList(); // 有序的关联对象集合

	public FruitStoryMenu() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getFruitStoryPicUrl() {
		return this.fruitStoryPicUrl;
	}

	public void setFruitStoryPicUrl(String fruitStoryPicUrl) {
		this.fruitStoryPicUrl = fruitStoryPicUrl;
	}

	public String getFruitStoryIntro() {
		return this.fruitStoryIntro;
	}

	public void setFruitStoryIntro(String fruitStoryIntro) {
		this.fruitStoryIntro = fruitStoryIntro;
	}

	// JPA 基于fruit_story_id列的多对一关系定义
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fruit_story_id")
	public FruitStory getFruitStory() {
		return fruitStory;
	}

	public void setFruitStory(FruitStory fruitStory) {
		this.fruitStory = fruitStory;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "fruitStoryMenu")
	public List<FruitStoryProcedure> getFruitStoryProcedureList() {
		return this.fruitStoryProcedureList;
	}

	public void setFruitStoryProcedureList(
			List<FruitStoryProcedure> fruitStoryProcedureList) {
		this.fruitStoryProcedureList = fruitStoryProcedureList;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "fruitStoryMenu")
	public List<FruitStoryMaterial> getFruitStoryMaterialList() {
		return fruitStoryMaterialList;
	}

	public void setFruitStoryMaterialList(
			List<FruitStoryMaterial> fruitStoryMaterialList) {
		this.fruitStoryMaterialList = fruitStoryMaterialList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
