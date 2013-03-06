package org.xmx0632.management.api.v1.bo;

public class FruitStoryMaterialBo {

	private String fruitName;
	private String fruitNum;

	public FruitStoryMaterialBo() {
	}

	public FruitStoryMaterialBo(String fruitName, String fruitNum) {
		this.fruitName = fruitName;
		this.fruitNum = fruitNum;
	}

	@Override
	public String toString() {
		return "FruitStoryMaterialBo [fruitName=" + fruitName + ", fruitNum="
				+ fruitNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fruitName == null) ? 0 : fruitName.hashCode());
		result = prime * result
				+ ((fruitNum == null) ? 0 : fruitNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitStoryMaterialBo other = (FruitStoryMaterialBo) obj;
		if (fruitName == null) {
			if (other.fruitName != null)
				return false;
		} else if (!fruitName.equals(other.fruitName))
			return false;
		if (fruitNum == null) {
			if (other.fruitNum != null)
				return false;
		} else if (!fruitNum.equals(other.fruitNum))
			return false;
		return true;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitNum() {
		return fruitNum;
	}

	public void setFruitNum(String fruitNum) {
		this.fruitNum = fruitNum;
	}

}
