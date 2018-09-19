package com.revature.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.RUser;

/**
 * 
 * @author jeremiah This controller will handle all user manipulation logic and
 *         provide access to the DAO services
 *
 */
public class UserController {

	private static Logger log = Logger.getRootLogger();
	private static Set<String> userNameSet = new HashSet<>();

	public UserController() {
		super();
	}

	private static void loadUsers() {
		UserDAO userDI = new UserDAOImpl();
		for (RUser u : userDI.getAllUsers()) {
			userNameSet.add(u.getuName());
		}
	}

	/**
	 * This controller method returns all users in the database as a JSON object to
	 * be handled by the view in our component.ts
	 * 
	 * @return array of JSON objects(as a string) containing user objects
	 */
	public static String getAllUsers() {
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
	/**
	 * 
	 * @return array of JSON objects(as a string) containing chef user objects
	 */
	public static String getAllChefs() {
		UserDAO ud = new UserDAOImpl();
		ObjectMapper om = new ObjectMapper();

		List<RUser> users = ud.getAllChefs();
		String userString = null;
		try {
			userString = om.writeValueAsString(users);
		} catch (JsonProcessingException a) {
			log.error(a);
		}
		return "{\"chefs\":" + userString + "}";
	}

	/**
	 * 
	 * @return array of JSON objects(as a string) containing default user objects
	 */
	public static String getAllDefaultUsers() {
		UserDAO ud = new UserDAOImpl();
		ObjectMapper om = new ObjectMapper();

		List<RUser> users = ud.getAllNonChefs();
		String userString = null;
		try {
			userString = om.writeValueAsString(users);
		} catch (JsonProcessingException a) {
			log.error(a);
		}
		return "{\"pleabs\":" + userString + "}";
	}

	/**
	 * 
	 * @param request
	 * @return a message detailing the results of the create action
	 */
	public static String createUser(HttpServletRequest request) {
		loadUsers();
		//TODO map return strings to be JSON w/objectmapper
		int setSize = userNameSet.size();
		boolean isNameAvailable = false;
		userNameSet.add(request.getParameter("userName"));
		if (setSize == userNameSet.size()) {
			return "User Name is already taken; please choose a different User Name.";
		}

		UserDAO udi = new UserDAOImpl();
		RUser user = new RUser();
		user.setEmail(request.getParameter("email"));
		user.setIsChef(0);
		user.setName(request.getParameter("name"));
		user.setuName(request.getParameter("userName"));
		user.setPswd(request.getParameter("pswd"));

		if (udi.createUser(user) > 0) {
			return "Success";
		} else {
			return "Failed";
		}

	}

	/**
	 * 
	 * @param request
	 * @param username
	 * @return the updated user object
	 * @throws JsonProcessingException 
	 */
	public static String updateProfile(HttpServletRequest request, String username) throws JsonProcessingException {
		/*
		 * Current logic assumes front end will not return any empty values. If user
		 * does not input a field, front end should return user's original profile info
		 * in the request body
		 */
		UserDAO udi = new UserDAOImpl();
		ObjectMapper om = new ObjectMapper();
		RUser user = udi.getUserByUserName(username);
		if (user == null) {
			log.info("UserController:updateProfile: User does not exist, or database lookup failed");
			return null;
		}
		user.setEmail(request.getParameter("email"));
		user.setName(request.getParameter("name"));
		user.setuName(request.getParameter("userName"));
		user.setPswd(request.getParameter("pswd"));
		RUser updatedU = udi.updateUser(user);
		if (updatedU != null) {
			String userStr = om.writeValueAsString(updatedU);
			return "{\"user\":" + userStr + "}";
		}
		return null;
	}

	public static boolean deleteUser(String username) {
		UserDAO udi = new UserDAOImpl();
		RUser user = udi.getUserByUserName(username);
		if(user == null) {
			log.info("User does not exist, or a databse error occured.");
			return false;
		}
		udi.deleteUser(user);
		return true;
	}
}
