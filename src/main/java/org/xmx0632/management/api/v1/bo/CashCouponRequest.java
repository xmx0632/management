package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class CashCouponRequest {

	private List<String> cashCouponIds = new ArrayList<String>();

	@Override
	public String toString() {
		return "CashCouponRequest [cashCouponIds=" + cashCouponIds + "]";
	}

	public List<String> getCashCouponIds() {
		return cashCouponIds;
	}

	public void setCashCouponIds(List<String> cashCouponIds) {
		this.cashCouponIds = cashCouponIds;
	}

}
