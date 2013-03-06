package org.xmx0632.management.api.v1.bo;

import java.math.BigDecimal;

public class FruitProductBo {

	private String productId;
	private String productName;
	private String spec;
	private String place;
	private int min;
	private int max;
	private String unit;
	private String keyword;
	private String expirationDate;
	private BigDecimal e6Price;
	private BigDecimal marketPrice;
	private String picUrl;
	private String wmPicUrl;
	private String introduction;
	private String description;
	private String descriptionPicUrl;
	private String wmDescriptionPicUrl;
	private String fruitCategoryId;

	@Override
	public String toString() {
		return "FruitProductBo [productId=" + productId + ", productName="
				+ productName + ", spec=" + spec + ", place=" + place
				+ ", min=" + min + ", max=" + max + ", unit=" + unit
				+ ", keyword=" + keyword + ", expirationDate=" + expirationDate
				+ ", e6Price=" + e6Price + ", marketPrice=" + marketPrice
				+ ", picUrl=" + picUrl + ", wmPicUrl=" + wmPicUrl
				+ ", introduction=" + introduction + ", description="
				+ description + ", descriptionPicUrl=" + descriptionPicUrl
				+ ", wmDescriptionPicUrl=" + wmDescriptionPicUrl
				+ ", fruitCategoryId=" + fruitCategoryId + "]";
	}

	public String getWmPicUrl() {
		return wmPicUrl;
	}

	public void setWmPicUrl(String wmPicUrl) {
		this.wmPicUrl = wmPicUrl;
	}

	public String getWmDescriptionPicUrl() {
		return wmDescriptionPicUrl;
	}

	public void setWmDescriptionPicUrl(String wmDescriptionPicUrl) {
		this.wmDescriptionPicUrl = wmDescriptionPicUrl;
	}

	public String getFruitCategoryId() {
		return fruitCategoryId;
	}

	public void setFruitCategoryId(String fruitCategoryId) {
		this.fruitCategoryId = fruitCategoryId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public BigDecimal getE6Price() {
		return e6Price;
	}

	public void setE6Price(BigDecimal e6Price) {
		this.e6Price = e6Price;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionPicUrl() {
		return descriptionPicUrl;
	}

	public void setDescriptionPicUrl(String descriptionPicUrl) {
		this.descriptionPicUrl = descriptionPicUrl;
	}

}
