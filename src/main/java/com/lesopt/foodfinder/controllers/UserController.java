package com.lesopt.foodfinder.controllers; 

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lesopt.foodfinder.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lesopt.foodfinder.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jeremiah
 *
 */
@RestController
@CrossOrigin
public class UserController {

  @Autowired
  UserRepository userRepo;   

  @GetMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();  
	}
  
  @GetMapping(value="/chefs", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllChefs() {
		return userRepo.findByIsChef(User.IS_CHEF);  
	}

  @GetMapping(value="/chefs/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findChefById(@PathVariable("userId") Integer userId) {
		return userRepo.findByUserIdAndIsChef(userId, User.IS_CHEF);
	}

  @GetMapping(value="/users/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUserById(@PathVariable("userId") Integer userId) {
		return userRepo.findByUserIdAndIsChef(userId, User.IS_NOT_CHEF);
	}

	@RequestMapping(method=RequestMethod.POST, value="/new")
	public static String createUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("passw") String passw) {
		
		//loadUsers();
		//int setSize = usernameSet.size();
		//usernameSet.add(username);
		//if (setSize == usernameSet.size()) {
		//	return "User Name is already taken; please choose a different User Name.";
		//}
		User user = new User();
		user.setEmail(email);
		user.setIsChef(User.IS_NOT_CHEF);
		user.setUsername(username);
		user.setPassw(passw);

		
		
    return "heyo";
		//return userServ.createUser(user).getuName();

	}

//	/**
//	 * 
//	 * @param request
//	 * @param username
//	 * @return the updated user object
//	 * @throws JsonProcessingException 
//	 */
//	@RequestMapping(method=RequestMethod.POST, value="/updateUser")
//	public static User updateProfile(@RequestParam("name") String name, @RequestParam("username") String username,
//			@RequestParam("email") String email, @RequestParam("pswd") String pswd) throws JsonProcessingException {
//		/*
//		 * Current logic assumes front end will not return any empty values. If user
//		 * does not input a field, front end should return user's original profile info
//		 * in the request body
//		 */
//		
//		User user = userServ.getUserByUserName(username);
//		if (user == null) {
//			log.info("UserController:updateProfile: User does not exist, or database lookup failed");
//			return null;
//		}
//		user.setEmail(email);
//		user.setName(name);
//		user.setPswd(pswd);
//		return userServ.updateUSer(user);
//	}
//	@RequestMapping(method=RequestMethod.POST, value="/deleteUser")
//	public static boolean deleteUser(@RequestParam("username") String username) {
//		User user = userServ.getUserByUserName(username);
//		if(user == null) {
//			log.info("User does not exist, or a databse error occured.");
//			return false;
//		}
//		userServ.deleteUser(user);
//		return true;
//	}
}
