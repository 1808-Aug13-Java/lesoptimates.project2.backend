package com.revature.util;

import org.apache.log4j.Logger;
import org.dom4j.rule.Rule;
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

		Session s = HibernateUtil.getSession();
		s.close();
		RecipeDaoImpl rdi = new RecipeDaoImpl();
		UserDAO ud = new UserDAOImpl();
		Recipe recipe1 = new Recipe("Chillie Mac");
		RUser user = new RUser();
		user.setEmail("email");
		user.setIsChef(0);
		user.setName("Jaquolin");
		user.setuName("NastyOnasis");
		user.setPswd("weakpassword");
		ud.createUser(user);
		
		user.setEmail("email");
		user.setIsChef(1);
		user.setName("Dr. Girlfriend");
		user.setuName("LadyOpare");
		user.setPswd("weakpassword");
		ud.createUser(user);
		
		
		recipe1.setUser(user);
		int pk = rdi.saveRecipe(recipe1);
		log.info("################ driver recipe after save " + recipe1.toString());
		recipe1.setRecipeId(pk);
		log.info("################ driver recipe after save after id set " + recipe1.toString());
	
//		recipe1.setrecipeJSON("09876 test");

//		rdi.mergeRecipe(recipe1);
		log.info("##########Driver: " + rdi.getRecipe(recipe1.getRecipeId()));

		recipe1.setrecipeJSON("Fried Rice");

		rdi.updateRecipe(recipe1);

		log.info("##########Driver after recipe update: " + rdi.getRecipe(recipe1.getRecipeId()));
		log.info("########Get all Users: " + UserController.getAllUsers());
		
		Recipe recipe2 = new Recipe("persist test");

		rdi.persistRecipe(recipe2);
		
	}
	
	
	
}
