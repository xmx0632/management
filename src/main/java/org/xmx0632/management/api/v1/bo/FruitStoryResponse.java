package org.xmx0632.management.api.v1.bo;

public class FruitStoryResponse {
	private Result result;
	private String TTL;
	private FruitStoryBo fruitStory;

	@Override
	public String toString() {
		return "FruitStoryResponse [result=" + result + ", TTL=" + TTL
				+ ", fruitStory=" + fruitStory + "]";
	}

	public String getTTL() {
		return TTL;
	}

	public void setTTL(String tTL) {
		TTL = tTL;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public FruitStoryBo getFruitStory() {
		return fruitStory;
	}

	public void setFruitStory(FruitStoryBo fruitStory) {
		this.fruitStory = fruitStory;
	}

}
