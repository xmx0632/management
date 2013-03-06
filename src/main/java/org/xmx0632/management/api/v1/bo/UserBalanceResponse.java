package org.xmx0632.management.api.v1.bo;

import java.math.BigDecimal;

public class UserBalanceResponse {
	private Result result;
	private BigDecimal balance;

	@Override
	public String toString() {
		return "UserBalanceResponse [result=" + result + ", balance=" + balance
				+ "]";
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal d) {
		this.balance = d;
	}

}
