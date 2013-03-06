package org.xmx0632.management.api.v1.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SettlementResponse {

	private Result result;

	private String transactionID;
	// 总价
	private BigDecimal totalPrice;
	// 实际需支付
	private BigDecimal actualAmount;
	// 用户当前可享受的促销活动
	private PromotionInfo promotionInfo;

	// 促销提示
	private List<String> promotionTips = new ArrayList<String>();

	@Override
	public String toString() {
		return "SettlementResponse [result=" + result + ", transactionID="
				+ transactionID + ", totalPrice=" + totalPrice
				+ ", actualAmount=" + actualAmount + ", promotionInfo="
				+ promotionInfo + ", promotionTips=" + promotionTips + "]";
	}

	public List<String> getPromotionTips() {
		return promotionTips;
	}

	public void setPromotionTips(List<String> promotionTips) {
		this.promotionTips = promotionTips;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public PromotionInfo getPromotionInfo() {
		return promotionInfo;
	}

	public void setPromotionInfo(PromotionInfo promotionInfo) {
		this.promotionInfo = promotionInfo;
	}

	public static class PromotionInfo {
		private PromotionDetails promotionForTotal;
		private PromotionDetails promotionForProduct;

		@Override
		public String toString() {
			return "PromotionInfo [promotionForTotal=" + promotionForTotal
					+ ", promotionForProduct=" + promotionForProduct + "]";
		}

		public PromotionDetails getPromotionForTotal() {
			return promotionForTotal;
		}

		public void setPromotionForTotal(PromotionDetails promotionForTotal) {
			this.promotionForTotal = promotionForTotal;
		}

		public PromotionDetails getPromotionForProduct() {
			return promotionForProduct;
		}

		public void setPromotionForProduct(PromotionDetails promotionForProduct) {
			this.promotionForProduct = promotionForProduct;
		}

	}

	public static class PromotionDetails {
		private BigDecimal priceOff;
		private List<ProductFreeInfo> productsFree = new ArrayList<ProductFreeInfo>();

		@Override
		public String toString() {
			return "PromotionDetails [priceOff=" + priceOff + ", productsFree="
					+ productsFree + "]";
		}

		public BigDecimal getPriceOff() {
			return priceOff;
		}

		public void setPriceOff(BigDecimal priceOff) {
			this.priceOff = priceOff;
		}

		public List<ProductFreeInfo> getProductsFree() {
			return productsFree;
		}

		public void setProductsFree(List<ProductFreeInfo> productsFree) {
			this.productsFree = productsFree;
		}

	}

	public static class ProductFreeInfo {
		private String productName;
		private int amount;
		private String unit;
		private String spec;

		@Override
		public String toString() {
			return "ProductFreeInfo [productName=" + productName + ", amount="
					+ amount + ", unit=" + unit + ", spec=" + spec + "]";
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getSpec() {
			return spec;
		}

		public void setSpec(String spec) {
			this.spec = spec;
		}

	}

}
