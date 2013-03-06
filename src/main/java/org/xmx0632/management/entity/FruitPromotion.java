package org.xmx0632.management.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FruitPromotion.
 */
@Entity
@Table(name = "tbl_fruit_promotion")
public class FruitPromotion extends IdEntity {

	public static String PIC_STATUS_NOTREADY = "0";
	public static String PIC_STATUS_READY = "1";

	public static enum PromotionType {
		TOTAL_GIFT("total.gift", 0), TOTAL_EXCHANGE("total.exchange", 1), TOTAL_PRICEOFF(
				"total.priceoff", 2), PRODUCT_GIFT("product.gift", 3), PRODUCT_EXCHANGE(
				"product.exchange", 4), PRODUCT_PRICEOFF("product.priceoff", 4);
		private String name;
		private int value;

		public static String getNameByValue(int value) {
			for (PromotionType type : PromotionType.values()) {
				if (type.getValue() == value) {
					return type.getName();
				}
			}

			return null;
		}

		private PromotionType(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	public static enum Avaliable {
		OFFLINE("offline", 0), ONLINE("online", 1), OFFLINE_BYMOBILE(
				"offlinebymobile", 2);
		private String name;
		private int value;

		public static String getNameByValue(int value) {
			for (Avaliable type : Avaliable.values()) {
				if (type.getValue() == value) {
					return type.getName();
				}
			}

			return null;
		}

		private Avaliable(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	private Long subid;
	private String flowid;
	private String promotionName;
	private byte promotionType;
	private byte avaliable;
	private Date startTime;
	private Date endTime;
	private BigDecimal totalGift;
	private BigDecimal totalExchange;
	private BigDecimal totalPriceoff;
	private BigDecimal priceoff;
	private String picUrl;
	private String picStatus;

	public FruitPromotion() {
	}

	public FruitPromotion(String promotionName, byte promotionType,
			byte avaliable) {
		this.promotionName = promotionName;
		this.promotionType = promotionType;
		this.avaliable = avaliable;
	}

	@NotNull
	public String getPicStatus() {
		return picStatus;
	}

	public void setPicStatus(String picStatus) {
		this.picStatus = picStatus;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Long getSubid() {
		return this.subid;
	}

	public void setSubid(Long subid) {
		this.subid = subid;
	}

	public String getFlowid() {
		return this.flowid;
	}

	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}

	@NotNull
	public String getPromotionName() {
		return this.promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	@NotNull
	public byte getPromotionType() {
		return this.promotionType;
	}

	public void setPromotionType(byte promotionType) {
		this.promotionType = promotionType;
	}

	@NotNull
	public byte getAvaliable() {
		return this.avaliable;
	}

	public void setAvaliable(byte avaliable) {
		this.avaliable = avaliable;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getTotalGift() {
		return this.totalGift;
	}

	public void setTotalGift(BigDecimal totalGift) {
		this.totalGift = totalGift;
	}

	public BigDecimal getTotalExchange() {
		return this.totalExchange;
	}

	public void setTotalExchange(BigDecimal totalExchange) {
		this.totalExchange = totalExchange;
	}

	public BigDecimal getTotalPriceoff() {
		return this.totalPriceoff;
	}

	public void setTotalPriceoff(BigDecimal totalPriceoff) {
		this.totalPriceoff = totalPriceoff;
	}

	public BigDecimal getPriceoff() {
		return this.priceoff;
	}

	public void setPriceoff(BigDecimal priceoff) {
		this.priceoff = priceoff;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
