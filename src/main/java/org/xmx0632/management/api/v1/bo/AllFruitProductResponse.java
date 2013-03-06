package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class AllFruitProductResponse {

	private Result result;
	private String TTL;
	private List<FruitProductBo> fruitProducts = new ArrayList<FruitProductBo>();

	@Override
	public String toString() {
		return "AllFruitProductResponse [result=" + result + ", TTL=" + TTL
				+ ", fruitProducts=" + fruitProducts + "]";
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getTTL() {
		return TTL;
	}

	public void setTTL(String tTL) {
		TTL = tTL;
	}

	public List<FruitProductBo> getFruitProducts() {
		return fruitProducts;
	}

	public void setFruitProducts(List<FruitProductBo> fruitProducts) {
		this.fruitProducts = fruitProducts;
	}

}
