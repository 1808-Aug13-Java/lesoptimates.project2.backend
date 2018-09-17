package com.revature.dao;

import java.util.List;

import javax.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.RUser;
import com.revature.models.Recipe;
import com.revature.util.HibernateUtil;

public class RecipeDaoImpl implements RecipeDao{
	private static Logger log = Logger.getRootLogger();

	@Override
	public int saveRecipe(Recipe recipe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int recipePK = (int) s.save(recipe);
		tx.commit();
		s.close();
		return recipePK;
	}


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

	@Override
	public List<Recipe> getAllRecipes() {
		Session s = HibernateUtil.getSession();
		List<Recipe> recipes = s.createQuery("from Recipe").list();
		s.close();
		return recipes;
	}

	@Override
	public List<Recipe> getAllRecipesByUser(RUser user) {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("userId", user.getUserId()));
		List<Recipe> recipes = cr.list();
		s.close();
		return recipes;
	}

}
