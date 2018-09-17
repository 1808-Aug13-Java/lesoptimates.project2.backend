package com.revature.dao;

import com.revature.models.Recipe;

public interface RecipeDao {
	
	public int createRecipe(Recipe recipe);
	public Recipe updateRecipe(Recipe recipe);
	

}
