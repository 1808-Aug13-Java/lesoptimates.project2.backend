package com.revature.dao;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Recipe;
import com.revature.util.HibernateUtil;

public class RecipeDaoImpl implements RecipeDao{

	@Override
	public int createRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int recipePK = (int) s.save(recipe);
		tx.commit();
		s.close();
		return recipePK;
	}

	//@Table
	public Recipe updateRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Recipe updatedRecipe = (Recipe) s.merge("RECIPE", recipe);
		tx.commit();
		return updatedRecipe;
	}

}
