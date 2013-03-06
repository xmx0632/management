package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class FruitStoryMenuBo {

	private String productId;
	private String fruitStoryIntro;
	private String fruitStoryPicUrl;
	private String fruitStoryWmPicUrl;
	private List<FruitStoryMaterialBo> materials = new ArrayList<FruitStoryMaterialBo>();
	private List<FruitStoryProcedureBo> procedures = new ArrayList<FruitStoryProcedureBo>();

	public FruitStoryMenuBo() {
	}

	public FruitStoryMenuBo(String productId, String fruitStoryIntro,
			String fruitStoryPicUrl) {
		this.productId = productId;
		this.fruitStoryIntro = fruitStoryIntro;
		this.fruitStoryPicUrl = fruitStoryPicUrl;
	}

	@Override
	public String toString() {
		return "FruitStoryMenuBo [productId=" + productId
				+ ", fruitStoryIntro=" + fruitStoryIntro
				+ ", fruitStoryPicUrl=" + fruitStoryPicUrl
				+ ", fruitStoryWmPicUrl=" + fruitStoryWmPicUrl + ", materials="
				+ materials + ", procedures=" + procedures + "]";
	}

	public String getFruitStoryWmPicUrl() {
		return fruitStoryWmPicUrl;
	}

	public void setFruitStoryWmPicUrl(String fruitStoryWmPicUrl) {
		this.fruitStoryWmPicUrl = fruitStoryWmPicUrl;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFruitStoryIntro() {
		return fruitStoryIntro;
	}

	public void setFruitStoryIntro(String fruitStoryIntro) {
		this.fruitStoryIntro = fruitStoryIntro;
	}

	public String getFruitStoryPicUrl() {
		return fruitStoryPicUrl;
	}

	public void setFruitStoryPicUrl(String fruitStoryPicUrl) {
		this.fruitStoryPicUrl = fruitStoryPicUrl;
	}

	public List<FruitStoryMaterialBo> getMaterials() {
		return materials;
	}

	public void setMaterials(List<FruitStoryMaterialBo> materials) {
		this.materials = materials;
	}

	public List<FruitStoryProcedureBo> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<FruitStoryProcedureBo> procedures) {
		this.procedures = procedures;
	}

}
