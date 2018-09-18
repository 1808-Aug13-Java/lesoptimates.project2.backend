package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.RUser;
import com.revature.models.Recipe;

public class UserController {

	private static Logger log = Logger.getRootLogger();
	
	public UserController() {
		super();
	}
	/**
	 * This controller method returns all users in the database as a JSON object to be handled by the view
	 * in our component.ts
	 * @return JSON object containing list of user objects
	 */
	public static String getAllUsers(){
		UserDAO ud = new UserDAOImpl();
		ObjectMapper om = new ObjectMapper();

		List<RUser> users = ud.getAllUsers();
		String userString = null;
		try {
			userString = om.writeValueAsString(users);
		} catch (JsonProcessingException a) {
			log.error(a);
		}
		return "{\"users\":" + userString + "}";
	}
	
	public static List<RUser> getAllChefs(){
		return null;
	}
	
	public static List<RUser> getAllDefaultUsers(){
		return null;
	}
	
	public static List<Recipe> getRecipesByUser(){
		return null;
	}
	
	public static int createUser(HttpServletRequest request) {
		return 0;
	}
	
	public static RUser updateProfile(HttpServletRequest request, String username) {
		return null;
	}

	public static int deleteUser(HttpServletRequest request, String username) {
		return 0;
	}
}
