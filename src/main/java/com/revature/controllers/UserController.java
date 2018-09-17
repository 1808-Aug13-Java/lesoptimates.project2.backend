package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.models.RUser;
import com.revature.models.Recipe;

public class UserController {

	private static Logger log = Logger.getRootLogger();
	
	private UserController() {
		super();
	}
	
	public List<RUser> getAllUsers(){
		return null;
	}
	
	public List<RUser> getAllChefs(){
		return null;
	}
	
	public List<RUser> getAllDefaultUsers(){
		return null;
	}
	
	public List<Recipe> getRecipesByUser(){
		return null;
	}
	
	public int createUser(HttpServletRequest request) {
		return 0;
	}
	
	public RUser updateProfile(HttpServletRequest request, String username) {
		return null;
	}

	public int deleteUser(HttpServletRequest request, String username) {
		return 0;
	}
}
