package com.revature.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.dao.RecipeDaoImpl;
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
		Recipe recipe1 = new Recipe("12345 test");
		
		int pk = rdi.saveRecipe(recipe1);
		log.info("Stuff " + recipe1.toString());
//		recipe1.setRecipeId(pk);
	
//		recipe1.setrecipeJSON("09876 test");

//		rdi.mergeRecipe(recipe1);
//		log.info(rdi.loadRecipe(recipe1.getRecipeId()));
//		log.info(rdi.loadRecipe(recipe1.getRecipeId()));
//		log.info(rdi.getRecipe(recipe1.getRecipeId()));

//		recipe1.setrecipeJSON("56787 test");

//		rdi.updateRecipe(recipe1);

//		Recipe recipe2 = new Recipe("persist test");

//		rdi.persistRecipe(recipe2);
		
	}
	
	
	
}
