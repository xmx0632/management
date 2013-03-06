package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class PromotionRuleResponse {

	private Result result;
	private PromotionRuleBo promotionRules;

	@Override
	public String toString() {
		return "PromotionRuleResponse [result=" + result + ", promotionRules="
				+ promotionRules + "]";
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public PromotionRuleBo getPromotionRules() {
		return promotionRules;
	}

	public void setPromotionRules(PromotionRuleBo promotionRules) {
		this.promotionRules = promotionRules;
	}

	public static class PromotionRuleBo {
		// 全场促销
		private List<PromotionTotalBo> promotionsTotal = new ArrayList<PromotionTotalBo>();
		// 单品促销
		private List<PromotionProductBo> promotionsProduct = new ArrayList<PromotionProductBo>();

		@Override
		public String toString() {
			return "PromotionRuleBo [promotionsTotal=" + promotionsTotal
					+ ", promotionsProduct=" + promotionsProduct + "]";
		}

		public List<PromotionTotalBo> getPromotionsTotal() {
			return promotionsTotal;
		}

		public void setPromotionsTotal(List<PromotionTotalBo> promotionsTotal) {
			this.promotionsTotal = promotionsTotal;
		}

		public List<PromotionProductBo> getPromotionsProduct() {
			return promotionsProduct;
		}

		public void setPromotionsProduct(
				List<PromotionProductBo> promotionsProduct) {
			this.promotionsProduct = promotionsProduct;
		}

	}

	public static class PromotionTotalBo {
		private String promotionId;
		private String content;
		private String picUrl;
		private String startTime;
		private String endTime;

		@Override
		public String toString() {
			return "PromotionTotalBo [promotionId=" + promotionId
					+ ", content=" + content + ", picUrl=" + picUrl
					+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
		}

		public String getPromotionId() {
			return promotionId;
		}

		public void setPromotionId(String promotionId) {
			this.promotionId = promotionId;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

	}

	public static class PromotionProductBo {
		private String promotionId;
		private String content;
		private String productId;
		private String picUrl;
		private String startTime;
		private String endTime;

		@Override
		public String toString() {
			return "PromotionProductBo [promotionId=" + promotionId
					+ ", content=" + content + ", productId=" + productId
					+ ", picUrl=" + picUrl + ", startTime=" + startTime
					+ ", endTime=" + endTime + "]";
		}

		public String getPromotionId() {
			return promotionId;
		}

		public void setPromotionId(String promotionId) {
			this.promotionId = promotionId;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

	}

}
