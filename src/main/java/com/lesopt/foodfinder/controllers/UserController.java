package com.lesopt.foodfinder.controllers; 

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @RequestMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
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

	@PostMapping(value="/users/new", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User u) {
    if(userRepo.existsByUsername(u.getUsername())) {
      return "redirect:/users/new";
    }
    userRepo.save(u);
    return "redirect:/";

	}

	@DeleteMapping(value="/users/{username}")
	public void deleteUser(@PathVariable("username") String username) {
    User user = userRepo.findByUsername(username);
    userRepo.delete(user);
	}

	@PutMapping(value="/users/{username}")
	public void updateUser(@RequestBody User user) throws JsonProcessingException {
		userRepo.save(user);
	}
}
