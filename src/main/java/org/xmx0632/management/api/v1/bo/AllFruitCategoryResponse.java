package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class AllFruitCategoryResponse {

	private Result result;
	private String TTL;
	private List<FruitCategoryBo> fruitCategories = new ArrayList<FruitCategoryBo>();

	@Override
	public String toString() {
		return "AllFruitCategoryResponse [result=" + result + ", TTL=" + TTL
				+ ", fruitCategories=" + fruitCategories + "]";
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

	public List<FruitCategoryBo> getFruitCategories() {
		return fruitCategories;
	}

	public void setFruitCategories(List<FruitCategoryBo> fruitCategories) {
		this.fruitCategories = fruitCategories;
	}

}
