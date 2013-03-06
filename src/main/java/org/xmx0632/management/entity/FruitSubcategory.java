package org.xmx0632.management.entity;

import java.util.List;

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
 * FruitSubcategory.
 */
@Entity
@Table(name = "tbl_fruit_subcategory")
public class FruitSubcategory extends IdEntity {

	private String fruitType;
	private String name;
	private FruitCategory fruitCategory;

	public FruitSubcategory() {
	}

	private List<FruitProduct> fruitProducts = Lists.newArrayList();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fruitSubcategory")
	public List<FruitProduct> getFruitProducts() {
		return fruitProducts;
	}

	public void setFruitProducts(List<FruitProduct> fruitProducts) {
		this.fruitProducts = fruitProducts;
	}

	@NotNull
	public String getFruitType() {
		return this.fruitType;
	}

	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	public FruitCategory getFruitCategory() {
		return fruitCategory;
	}

	public void setFruitCategory(FruitCategory fruitCategory) {
		this.fruitCategory = fruitCategory;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
