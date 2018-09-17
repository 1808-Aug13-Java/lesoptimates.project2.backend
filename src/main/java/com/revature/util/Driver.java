package com.revature.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.dao.RecipeDaoImpl;
import com.revature.models.Recipe;

public class Driver {

	public static void main(String[] args) {
		
		final Logger logger = Logger.getLogger(Driver.class);
		
		Session s = HibernateUtil.getSession();
		
		RecipeDaoImpl rdi = new RecipeDaoImpl();
		Recipe recipe1 = new Recipe("12345 test");
		
		int pk = rdi.saveRecipe(recipe1);
		recipe1.setRecipeId(pk);
		
		recipe1.setRecipeJON("09876 test");
		
		rdi.mergeRecipe(recipe1);
		logger.info(rdi.loadRecipe(recipe1.getRecipeId()));
		logger.info(rdi.loadRecipe(recipe1.getRecipeId()));
		logger.info(rdi.getRecipe(recipe1.getRecipeId()));
		
		recipe1.setRecipeJON("56787 test");
		
		rdi.updateRecipe(recipe1);
		
		Recipe recipe2 = new Recipe("persist test");
		
		rdi.persistRecipe(recipe2);
		
		s.close();
		
	}
	
	
	
}
