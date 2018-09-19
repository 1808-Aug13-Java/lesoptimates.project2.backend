package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.RecipeDao;
import com.revature.dao.RecipeDaoImpl;
import com.revature.models.RUser;
import com.revature.models.Recipe;

public class RecipeController {
	
	private static Logger log = Logger.getRootLogger();
		
	public void printRecipeByRecipeId(int recipeId) {
		ObjectMapper om = new ObjectMapper();
		try {
			RecipeDao rdi = new RecipeDaoImpl();
			Recipe recipe = rdi.getRecipeByRecipeId(recipeId);
			
			String recipeString = om.writeValueAsString(recipe);
			recipeString = "{\"recipes\":"+recipeString+"}";
			log.info(recipeString);
			

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void printRecipe(Recipe recipe) {
		ObjectMapper om = new ObjectMapper();
		try {
			
			String recipeString = om.writeValueAsString(recipe);
			recipeString = "{\"recipes\":"+recipeString+"}";
			log.info(recipeString);
			

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public void printRecipesByUserId(int userId) {
		ObjectMapper om = new ObjectMapper();
		try {
			RecipeDao rdi = new RecipeDaoImpl();
			List<Recipe> recipes = rdi.getAllRecipesByUserId(userId);
			
			String recipesString = om.writeValueAsString(recipes);
			recipesString = "{\"recipes\":"+recipesString+"}";
			log.info(recipesString);
			

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
	public void printAllRecipes() {
		ObjectMapper om = new ObjectMapper();
		try {
			RecipeDao rdi = new RecipeDaoImpl();
			List<Recipe> recipes = rdi.getAllRecipes();
			
			String recipesString = om.writeValueAsString(recipes);
			recipesString = "{\"recipes\":"+recipesString+"}";
			log.info(recipesString);
			

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
	}
	
	public void printRecipesByUser(RUser user) {
		ObjectMapper om = new ObjectMapper();
		try {
			RecipeDao rdi = new RecipeDaoImpl();
			List<Recipe> recipes = rdi.getAllRecipesByUser(user);
			
			String recipesString = om.writeValueAsString(recipes);
			recipesString = "{\"recipes\":"+recipesString+"}";
			log.info(recipesString);
			

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
	}

}
