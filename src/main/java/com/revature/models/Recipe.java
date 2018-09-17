package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recipeIdSequence")
	@SequenceGenerator(name="recipeIdSequence", allocationSize=1, sequenceName="SQ_RECIPEID_PK")
	@Column(name="USER_ID")
	@JsonProperty
	private int recipeId;
	
	@Lob
	@Column( name = "RECIPEJSON" )
	@JsonProperty
	private String recipeJON;
	

	public Recipe() {
		super();
	}


	public Recipe(String recipeJON) {
		super();
		this.recipeJON = recipeJON;
	}




	public int getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}


	public String getRecipeJON() {
		return recipeJON;
	}


	public void setRecipeJON(String recipeJON) {
		this.recipeJON = recipeJON;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipeId;
		result = prime * result + ((recipeJON == null) ? 0 : recipeJON.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (recipeId != other.recipeId) {
			return false;
		}
		if (recipeJON == null) {
			if (other.recipeJON != null) {
				return false;
			}
		} else if (!recipeJON.equals(other.recipeJON)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeJON=" + recipeJON + "]";
	}
	

}
