package com.abnamro.recipe.recipeapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe implements Comparable<Recipe>{
	@Id
	@GeneratedValue
	private Long recipieId;
	private String recipeName;
	private String dateOfCreation;
	private String imageUrl;
	private String indicator;
	private int likeCount;
	private String cookingInstruction;
	private String ingredients;
	
	public Recipe() {
		super();
	}
	public Recipe(Long recipieId, String recipeName, String dateOfCreation, String imageUrl, String indicator,
			int likeCount, String cookingInstruction, String ingredients) {
		super();
		this.recipieId = recipieId;
		this.recipeName = recipeName;
		this.dateOfCreation = dateOfCreation;
		this.imageUrl = imageUrl;
		this.indicator = indicator;
		this.likeCount = likeCount;
		this.cookingInstruction = cookingInstruction;
		this.ingredients = ingredients;
	}
	public Long getRecipieId() {
		return recipieId;
	}
	public void setRecipieId(Long recipieId) {
		this.recipieId = recipieId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getCookingInstruction() {
		return cookingInstruction;
	}
	public void setCookingInstruction(String cookingInstruction) {
		this.cookingInstruction = cookingInstruction;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		
		this.ingredients = ingredients;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cookingInstruction == null) ? 0 : cookingInstruction.hashCode());
		result = prime * result + ((dateOfCreation == null) ? 0 : dateOfCreation.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((indicator == null) ? 0 : indicator.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + likeCount;
		result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
		result = prime * result + ((recipieId == null) ? 0 : recipieId.hashCode());
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
		Recipe other = (Recipe) obj;
		if (cookingInstruction == null) {
			if (other.cookingInstruction != null)
				return false;
		} else if (!cookingInstruction.equals(other.cookingInstruction))
			return false;
		if (dateOfCreation == null) {
			if (other.dateOfCreation != null)
				return false;
		} else if (!dateOfCreation.equals(other.dateOfCreation))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (indicator == null) {
			if (other.indicator != null)
				return false;
		} else if (!indicator.equals(other.indicator))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (likeCount != other.likeCount)
			return false;
		if (recipeName == null) {
			if (other.recipeName != null)
				return false;
		} else if (!recipeName.equals(other.recipeName))
			return false;
		if (recipieId == null) {
			if (other.recipieId != null)
				return false;
		} else if (!recipieId.equals(other.recipieId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipieId=" + recipieId + ", recipeName=" + recipeName + ", dateOfCreation=" + dateOfCreation
				+ ", imageUrl=" + imageUrl + ", indicator=" + indicator + ", likeCount=" + likeCount
				+ ", cookingInstruction=" + cookingInstruction + ", ingredients=" + ingredients + "]";
	}
	@Override
	public int compareTo(Recipe arg0) {
		return this.recipeName.compareTo(arg0.recipeName);
		
	}
	
}
