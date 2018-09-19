package com.revature.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.controllers.UserController;
import com.revature.dao.RecipeDaoImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.RUser;
import com.revature.models.Recipe;

public class Driver {

	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		
		/*
		  this is only needed to manually test the connection
		  */
		RecipeDaoImpl rdi = new RecipeDaoImpl();
		UserDAO ud = new UserDAOImpl();
		Recipe recipe1 = new Recipe("Chillie Mac");
		Recipe recipe2 = new Recipe("Gumbo");
		Recipe recipe3 = new Recipe("Staek and Tators");
		RUser user = new RUser();
		RUser user1 = new RUser();
//		user.setEmail("email");
//		user.setIsChef(0);
//		user.setName("Jaquolin");
//		user.setuName("NastyOnasis");
//		user.setPswd("weakpassword");
//		ud.createUser(user);
		
//		user1.setEmail("email");
//		user1.setIsChef(1);
//		user1.setName("Dr. Girlfriend");
//		user1.setuName("LadyAuPair");
//		user1.setPswd("weakpassword");
//		ud.createUser(user);
		
		
		recipe1.setUser(ud.getUserByUserName("NastyOnasis"));
		recipe3.setUser(ud.getUserByUserName("NastyOnasis"));
		recipe2.setUser(ud.getUserByUserName("LadyAuPair"));
		int pk = rdi.saveRecipe(recipe1);
		recipe1.setRecipeId(pk);
		int pk1 = rdi.saveRecipe(recipe2);
		recipe2.setRecipeId(pk1);
		int pk2 = rdi.saveRecipe(recipe3);
		recipe3.setRecipeId(pk2);
		log.info("driver recipe after save " + rdi.getRecipe(recipe1.getRecipeId()).toString());
		log.info("driver recipe after save " + rdi.getRecipe(recipe2.getRecipeId()).toString());
		log.info("driver recipe after save " + rdi.getRecipe(recipe3.getRecipeId()).toString());
	

		List<Recipe> recipes = rdi.getAllRecipesByUser(ud.getUserByUserName("NastyOnasis"));
		log.info("Driver called get all recipes by user: ");
		for (Recipe r: recipes) {
			log.info("Recipes by user: " + r.toString());
		}
		

		recipe1.setrecipeJSON("Fried Rice");

		rdi.updateRecipe(recipe1);

		log.info("Driver after recipe update: " + rdi.getRecipe(recipe1.getRecipeId()));
		log.info("Get all Users: " + UserController.getAllUsers());
		
		Recipe recipe4 = new Recipe("persist test");

		rdi.persistRecipe(recipe4);
		
	}
	
	
	
}
