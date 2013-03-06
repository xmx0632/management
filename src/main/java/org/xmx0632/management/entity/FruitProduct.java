package org.xmx0632.management.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FruitProduct.
 */
@Entity
@Table(name = "tbl_fruit_product")
public class FruitProduct extends IdEntity {

	public static String STATUS_ONLINE = "1";
	public static String STATUS_OFFLINE = "0";
	public static String PIC_STATUS_NOTREADY = "0";
	public static String PIC_STATUS_READY = "1";

	private String productId;
	private String productName;
	private String online;
	private String picStatus;
	private String spec;
	private String place;
	private int min;
	private int max;
	private String unit;
	private String keyword;
	private Date expirationDate;
	private BigDecimal e6Price;
	private BigDecimal marketPrice;
	private String picUrl;
	private String introduction;
	private String description;
	private String descriptionPicUrl;
	private FruitSubcategory fruitSubcategory;

	public FruitProduct() {
	}

	public FruitProduct(String productId, String productName, String online,
			String picStatus, String spec, String place, int min, int max,
			String unit, String keyword, Date expirationDate, String picUrl,
			String introduction, String description, String descriptionPicUrl) {
		this.productId = productId;
		this.productName = productName;
		this.online = online;
		this.picStatus = picStatus;
		this.spec = spec;
		this.place = place;
		this.min = min;
		this.max = max;
		this.unit = unit;
		this.keyword = keyword;
		this.expirationDate = expirationDate;
		this.picUrl = picUrl;
		this.introduction = introduction;
		this.description = description;
		this.descriptionPicUrl = descriptionPicUrl;
	}

	@NotNull
	public String getPicStatus() {
		return picStatus;
	}

	public void setPicStatus(String picStatus) {
		this.picStatus = picStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id")
	public FruitSubcategory getFruitSubcategory() {
		return fruitSubcategory;
	}

	public void setFruitSubcategory(FruitSubcategory fruitSubcategory) {
		this.fruitSubcategory = fruitSubcategory;
	}

	@NotNull
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@NotNull
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@NotNull
	public String getOnline() {
		return this.online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	@NotNull
	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@NotNull
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@NotNull
	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@NotNull
	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@NotNull
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@NotNull
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@NotNull
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "e6_price")
	public BigDecimal getE6Price() {
		return this.e6Price;
	}

	public void setE6Price(BigDecimal e6Price) {
		this.e6Price = e6Price;
	}

	public BigDecimal getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	@NotNull
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@NotNull
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@NotNull
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	public String getDescriptionPicUrl() {
		return this.descriptionPicUrl;
	}

	public void setDescriptionPicUrl(String descriptionPicUrl) {
		this.descriptionPicUrl = descriptionPicUrl;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
