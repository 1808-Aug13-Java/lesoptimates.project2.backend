package com.revature.util;

<<<<<<< HEAD
import org.hibernate.Session;

public class Driver {

	public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();
		s.close();
	}

=======
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.controllers.RecipeController;
import com.revature.dao.RecipeDao;
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
//		Session s = HibernateUtil.getSession();

//		RecipeDaoImpl rdi = new RecipeDaoImpl();
//		UserDAO ud = new UserDAOImpl();
//		Recipe recipe1 = new Recipe("Chillie Mac");
//		Recipe recipe2 = new Recipe("Gumbo");
//		Recipe recipe3 = new Recipe("Staek and Tators");
//		RUser user = new RUser();
//		RUser user1 = new RUser();
//		
//		s.close();
		
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
		
		
//		recipe1.setUser(ud.getUserByUserName("NastyOnasis"));
//		recipe3.setUser(ud.getUserByUserName("NastyOnasis"));
//		recipe2.setUser(ud.getUserByUserName("LadyAuPair"));
//		int pk = rdi.saveRecipe(recipe1);
//		recipe1.setRecipeId(pk);
//		int pk1 = rdi.saveRecipe(recipe2);
//		recipe2.setRecipeId(pk1);
//		int pk2 = rdi.saveRecipe(recipe3);
//		recipe3.setRecipeId(pk2);
//		log.info("driver recipe after save " + rdi.getRecipe(recipe1.getRecipeId()).toString());
//		log.info("driver recipe after save " + rdi.getRecipe(recipe2.getRecipeId()).toString());
//		log.info("driver recipe after save " + rdi.getRecipe(recipe3.getRecipeId()).toString());
//	
//
//		List<Recipe> recipes = rdi.getAllRecipesByUser(ud.getUserByUserName("NastyOnasis"));
//		log.info("Driver called get all recipes by user: ");
//		for (Recipe r: recipes) {
//			log.info("Recipes by user: " + r.toString());
//		}
//		
//
//		recipe1.setrecipeJSON("Fried Rice");
//
//		rdi.updateRecipe(recipe1);
//
//		log.info("Driver after recipe update: " + rdi.getRecipe(recipe1.getRecipeId()));
//		log.info("Get all Users: " + UserController.getAllUsers());
//		
//		Recipe recipe4 = new Recipe("persist test");
//
//		rdi.persistRecipe(recipe4);
//		
////		------------------------------------------------------------
//		UserDAO udi = new UserDAOImpl();
//		RecipeDao rdi = new RecipeDaoImpl();
//		
//		RUser user1 = new RUser();
//		user1.setuName("mark8");
//		user1.setEmail("mhamil@email.com");
//		user1.setName("Mark Hamilton");
//		user1.setPswd("passw0rd!2");
//		
//		int u1PK = udi.createUser(user1);
//		user1.setUserId(u1PK);
//		
//		RUser user2 = new RUser();
//		user2.setuName("ann7");
//		user2.setEmail("asmith@email.com");
//		user2.setName("Ann Smith");
//		user2.setPswd("passw0rd!6");
//		
//		int u2PK = udi.createUser(user2);
//		user2.setUserId(u2PK);
//		
//		RUser user3 = new RUser();
//		user3.setuName("franklin5");
//		user3.setEmail("fpeterson@email.com");
//		user3.setName("Franklin Peterson");
//		user3.setPswd("passw0rd!8");
//		
//		int u3PK = udi.createUser(user3);
//		user3.setUserId(u3PK);
//		
//		RUser user4 = new RUser();
//		user4.setuName("roger98");
//		user4.setEmail("rdennis@email.com");
//		user4.setName("Roger Dennis");
//		user4.setPswd("passw0rd!2");
//		
//		int u4PK = udi.createUser(user4);
//		user4.setUserId(u4PK);
//		
//		RUser user5 = new RUser();
//		user5.setuName("wil43");
//		user5.setEmail("wcrest@email.com");
//		user5.setName("William Crest");
//		user5.setPswd("passw0rd0!");
//		
//		int u5PK = udi.createUser(user5);
//		user5.setUserId(u5PK);
//		
//		
//		Recipe recipe1 = new Recipe();
//		recipe1.setrecipeJSON("test 1234");
//		recipe1.setUser(user1);
//		int r1PK = rdi.saveRecipe(recipe1);
//		
//		Recipe recipe2 = new Recipe();
//		recipe2.setrecipeJSON("test 76427");
//		recipe2.setUser(user2);
//		int r2PK = rdi.saveRecipe(recipe2);
//		
//		Recipe recipe3 = new Recipe();
//		recipe3.setrecipeJSON("test 98543");
//		recipe3.setUser(user3);
//		int r3PK = rdi.saveRecipe(recipe3);
//		
//		Recipe recipe4 = new Recipe();
//		recipe4.setrecipeJSON("test 87547");
//		recipe4.setUser(user4);
//		int r4PK = rdi.saveRecipe(recipe4);
//		
//		Recipe recipe5 = new Recipe();
//		recipe5.setrecipeJSON("test 865432");
//		recipe5.setUser(user5);
//		int r5PK = rdi.saveRecipe(recipe5);
//		
//		Recipe recipe6 = new Recipe();
//		recipe6.setrecipeJSON("test gsgrstgr");
//		recipe6.setUser(user2);
//		int r6PK = rdi.saveRecipe(recipe6);
//		
//		Recipe recipe7 = new Recipe();
//		recipe7.setrecipeJSON("test trgtrs34343");
//		recipe7.setUser(user1);
//		int r7PK = rdi.saveRecipe(recipe7);
//		
//		Recipe recipe8 = new Recipe();
//		recipe8.setrecipeJSON("test 5445grr43");
//		recipe8.setUser(user5);
//		int r8PK = rdi.saveRecipe(recipe8);
//		
//		Recipe recipe9 = new Recipe();
//		recipe9.setrecipeJSON("test 865mfmn432");
//		recipe9.setUser(user5);
//		int r9PK = rdi.saveRecipe(recipe9);
//		
//		Recipe recipe10 = new Recipe();
//		recipe10.setrecipeJSON("test 865432waefawf");
//		recipe10.setUser(user5);
//		int r10PK = rdi.saveRecipe(recipe10);
//		
//		
//		RecipeController rc = new RecipeController();
//		rc.printRecipeByRecipeId(r1PK);
//		rc.printAllRecipes();
//		rc.printRecipe(recipe1);
//		rc.printRecipesByUser(user1);
//		rc.printRecipesByUserId(u1PK);
//		
//		rc.printRecipeByRecipeId(r2PK);
//		rc.printRecipe(recipe2);
//		rc.printRecipesByUser(user2);
//		rc.printRecipesByUserId(u2PK);
//		
//		rc.printRecipeByRecipeId(r3PK);
//		rc.printRecipe(recipe3);
//		rc.printRecipesByUser(user3);
//		rc.printRecipesByUserId(u3PK);
//		
//		rc.printRecipeByRecipeId(r4PK);
//		rc.printRecipe(recipe4);
//		rc.printRecipesByUser(user4);
//		rc.printRecipesByUserId(u4PK);
//		
//		rc.printRecipeByRecipeId(r5PK);
//		rc.printRecipe(recipe5);
//		rc.printRecipesByUser(user5);
//		rc.printRecipesByUserId(u5PK);
		
		

		
		
	}
	
	
	
>>>>>>> c96a7c10968082faaa8ead982eb7bdad04968a01
}
