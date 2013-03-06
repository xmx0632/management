package org.xmx0632.management.api.v1.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashCouponResponse {

	private Result result;

	private List<CashCoupon> cashCoupons = new ArrayList<CashCoupon>();

	@Override
	public String toString() {
		return "CashCouponResponse [result=" + result + ", cashCoupons="
				+ cashCoupons + "]";
	}

	public List<CashCoupon> getCashCoupons() {
		return cashCoupons;
	}

	public void setCashCoupons(List<CashCoupon> cashCoupons) {
		this.cashCoupons = cashCoupons;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class CashCoupon {
		private String id;
		private int numberOfUseLeft;
		private BigDecimal value;

		@Override
		public String toString() {
			return "CashCoupon [id=" + id + ", numberOfUseLeft="
					+ numberOfUseLeft + ", value=" + value + "]";
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getNumberOfUseLeft() {
			return numberOfUseLeft;
		}

		public void setNumberOfUseLeft(int numberOfUseLeft) {
			this.numberOfUseLeft = numberOfUseLeft;
		}

		public BigDecimal getValue() {
			return value;
		}

		public void setValue(BigDecimal value) {
			this.value = value;
		}

	}

}
