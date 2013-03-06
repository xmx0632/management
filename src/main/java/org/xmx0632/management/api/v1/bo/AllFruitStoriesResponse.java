package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class AllFruitStoriesResponse {

	private Result result;
	private String TTL;
	private List<FruitStoryBo> fruitStories = new ArrayList<FruitStoryBo>();

	@Override
	public String toString() {
		return "AllFruitStoriesResponse [result=" + result + ", TTL=" + TTL
				+ ", fruitStories=" + fruitStories + "]";
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

	public List<FruitStoryBo> getFruitStories() {
		return fruitStories;
	}

	public void setFruitStories(List<FruitStoryBo> fruitStories) {
		this.fruitStories = fruitStories;
	}

}
