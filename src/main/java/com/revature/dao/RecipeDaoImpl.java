package com.revature.dao;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Recipe;
import com.revature.util.HibernateUtil;

public class RecipeDaoImpl implements RecipeDao{

	@Override
	public int saveRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int recipePK = (int) s.save(recipe);
		tx.commit();
		s.close();
		return recipePK;
	}

	//@Table
	public Recipe mergeRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Recipe mergedRecipe = (Recipe) s.merge("RECIPE", recipe);
		tx.commit();
		return mergedRecipe;
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(recipe);
		tx.commit();
		s.close();
	}

	@Override
	public void persistRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(recipe);
		tx.commit();
		s.close();
	}

	@Override
	public Recipe getRecipe(int recipeId) {
		Session s = HibernateUtil.getSession();
		Recipe recipe = (Recipe) s.get(Recipe.class, recipeId);
		s.close();
		return recipe;
	}

	@Override
	public Recipe loadRecipe(int recipeId) {
		Session s = HibernateUtil.getSession();
		Recipe recipe = (Recipe) s.load(Recipe.class, recipeId);
		s.close();
		return recipe;
		
	}

}
