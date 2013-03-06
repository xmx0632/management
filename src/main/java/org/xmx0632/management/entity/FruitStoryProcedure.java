package org.xmx0632.management.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * FruitStoryProcedure.
 */
@Entity
@Table(name = "tbl_fruit_story_procedure")
public class FruitStoryProcedure extends IdEntity {

	private String procedureIntro;
	private String procedurePic;
	private Integer seq;
	private FruitStoryMenu fruitStoryMenu;

	public FruitStoryProcedure() {
	}

	public String getProcedureIntro() {
		return this.procedureIntro;
	}

	public void setProcedureIntro(String procedureIntro) {
		this.procedureIntro = procedureIntro;
	}

	public String getProcedurePic() {
		return this.procedurePic;
	}

	public void setProcedurePic(String procedurePic) {
		this.procedurePic = procedurePic;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@ManyToOne
	@JoinColumn(name = "fruit_story_menu_id")
	public FruitStoryMenu getFruitStoryMenu() {
		return fruitStoryMenu;
	}

	public void setFruitStoryMenu(FruitStoryMenu fruitStoryMenu) {
		this.fruitStoryMenu = fruitStoryMenu;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
