package org.xmx0632.management.api.v1.bo;

public class FruitStoryProcedureBo {

	private String procedureIntro;
	private String procedurePic;
	private String wmProcedurePic;

	public FruitStoryProcedureBo() {
	}

	public FruitStoryProcedureBo(String procedureIntro, String procedurePic,
			String wmProcedurePic) {
		this.procedureIntro = procedureIntro;
		this.procedurePic = procedurePic;
		this.wmProcedurePic = wmProcedurePic;
	}

	@Override
	public String toString() {
		return "FruitStoryProcedureBo [procedureIntro=" + procedureIntro
				+ ", procedurePic=" + procedurePic + ", wmProcedurePic="
				+ wmProcedurePic + "]";
	}

	public String getWmProcedurePic() {
		return wmProcedurePic;
	}

	public void setWmProcedurePic(String wmProcedurePic) {
		this.wmProcedurePic = wmProcedurePic;
	}

	public String getProcedureIntro() {
		return procedureIntro;
	}

	public void setProcedureIntro(String procedureIntro) {
		this.procedureIntro = procedureIntro;
	}

	public String getProcedurePic() {
		return procedurePic;
	}

	public void setProcedurePic(String procedurePic) {
		this.procedurePic = procedurePic;
	}

}
