package com.revature.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.RUser;
import com.revature.services.UserService;


@Controller
@RestController
@CrossOrigin
public class LoginController {

	private static Logger log = Logger.getRootLogger();
	private static UserService userService = new UserService();
	
	private LoginController() {
		super();
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public RUser login(@RequestParam("userName") String username, @RequestParam("pswd")String password, HttpServletRequest request) {
		
	    RUser user = userService.authenticateUser(username, password);
	    if(user!=null) {
	    	HttpSession session = request.getSession();
	        session.setAttribute("USER", user);
	    } else {
	        return null;
	    }
	    return user;
	}
	
	@GetMapping("/session")
	public RUser getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			return (RUser) session.getAttribute("USER");
		}
	    return null;
	}

	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}

}
