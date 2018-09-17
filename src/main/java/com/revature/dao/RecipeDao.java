package com.revature.dao;

import com.revature.models.Recipe;

public interface RecipeDao {
	
	public int saveRecipe(Recipe recipe);
	public Recipe mergeRecipe(Recipe recipe);
	public void updateRecipe(Recipe recipe);
	public void persistRecipe(Recipe recipe);
	public Recipe getRecipe(int recipeId);
	public Recipe loadRecipe(int recipeId);

}
