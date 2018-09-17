package com.revature.util;

import org.hibernate.Session;

import com.revature.dao.RecipeDaoImpl;
import com.revature.models.Recipe;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		
		RecipeDaoImpl rdi = new RecipeDaoImpl();
		Recipe recipe = new Recipe("12345 test");
		
		int pk = rdi.createRecipe(recipe);
		recipe.setRecipeId(pk);
		
		recipe.setRecipeJON("09876 test");
		
		rdi.updateRecipe(recipe);
		
		s.close();
		
	}
	
	
	
}
