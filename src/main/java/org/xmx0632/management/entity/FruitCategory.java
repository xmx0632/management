package org.xmx0632.management.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

/**
 * FruitCategory.
 */
@Entity
@Table(name = "tbl_fruit_category")
public class FruitCategory extends IdEntity {

	private String name;
	private String iconUrl;
	private List<FruitSubcategory> fruitSubcategoryList = Lists.newArrayList();

	public FruitCategory() {
	}

	@NotNull
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fruitCategory", cascade = CascadeType.DETACH)
	public List<FruitSubcategory> getFruitSubcategoryList() {
		return fruitSubcategoryList;
	}

	public void setFruitSubcategoryList(
			List<FruitSubcategory> fruitSubcategoryList) {
		this.fruitSubcategoryList = fruitSubcategoryList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
