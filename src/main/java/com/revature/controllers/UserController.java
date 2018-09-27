
package com.revature.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.models.RUser;
import com.revature.services.UserService;

/**
 * 
 * @author jeremiah
 *
 */
@RestController
@CrossOrigin
public class UserController {

	private static Logger log = Logger.getRootLogger();
	private static Set<String> userNameSet = new HashSet<>();
	
	private static UserService userServ = new UserService();

	public UserController() {
		super();
	}
	
	private static void loadUsers() {
		for (RUser u : userServ.getAllUsers()) {
			userNameSet.add(u.getuName());
		}
	}

	/**
	 * This controller method returns all users in the database as a JSON object to
	 * be handled by the view in our component.ts
	 * 
	 * @return array of JSON objects(as a string) containing user objects
	 */
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="/getUsers")
	public static List<RUser> getAllUsers() {
		
		return userServ.getAllUsersExternal();
	}
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="/getUsers/{username}")
	public static RUser getUserByUsername(@PathVariable("username") String username) {
		
		return userServ.getUserByUserName(username);
	}
	
	/**
	 * This controller method returns all users in the database as a JSON object to
	 * be handled by the view in our component.ts
	 * 
	 * @return array of JSON objects(as a string) containing user objects
	 */
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="/getUsernames")
	public static List<RUser> getUsernames() {
		
		return userServ.getAllUsersExternal();
	}
	
	/**
	 * To get all Users with Chef status simply call this method with 
	 * getChefs appended to the url. 
	 * @return array of JSON objects(as a string) containing chef user objects
	 */
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value="/getChefs")
	public static List<RUser> getAllChefs() {
		
		return userServ.getAllChefs();
	}

	/**
	 * 
	 * @return array of JSON objects(as a string) containing default user objects
	 */
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value="/getDefaultUsers")
	public static List<RUser> getAllDefaultUsers() {
		
		return userServ.getAllDefaultUsers();
	}

	/**
	 * 
	 * @param request body from front end
	 * @return a message detailing the results of the create action
	 */
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public static String createUser(@RequestParam("name") String name, @RequestParam("userName") String userName,
			@RequestParam("email") String email, @RequestParam("pswd") String pswd) {
		
		loadUsers();
		int setSize = userNameSet.size();
		userNameSet.add(userName);
		if (setSize == userNameSet.size()) {
			return "User Name is already taken; please choose a different User Name.";
		}
		RUser user = new RUser();
		user.setEmail(email);
		user.setIsChef(0);
		user.setName(name);
		user.setuName(userName);
		user.setPswd(pswd);
		
		return userServ.createUser(user).getuName();

	}

	/**
	 * 
	 * @param request
	 * @param username
	 * @return the updated user object
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/updateUser")
	public static RUser updateProfile(@RequestParam("id") String userId, @RequestParam("name") String name, @RequestParam("userName") String userName,
			@RequestParam("email") String email, @RequestParam("pswd") String pswd) throws JsonProcessingException {
		/*
		 * Current logic assumes front end will not return any empty values. If user
		 * does not input a field, front end should return user's original profile info
		 * in the request body
		 */
		
		RUser user = userServ.getUserById(Integer.parseInt(userId));
		if (user == null) {
			log.info("UserController:updateProfile: User does not exist, or database lookup failed");
			return null;
		}
		user.setEmail(email);
		user.setName(name);
		user.setPswd(pswd);
		return userServ.updateUSer(user);
	}
	@RequestMapping(method=RequestMethod.POST, value="/deleteUser")
	public static boolean deleteUser(@RequestParam("userName") String userName) {
		RUser user = userServ.getUserByUserName(userName);
		if(user == null) {
			log.info("User does not exist, or a databse error occured.");
			return false;
		}
		userServ.deleteUser(user);
		return true;
	}
}
