package com.revature.services;

import java.lang.reflect.Member;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.RUser;

public class UserService {

	private static UserDAO ud = new UserDAOImpl();
	public UserService() {
		super();
	}
	
	public List<RUser> getAllUsers(){
		return ud.getAllUsers();
	}
	
	public List<RUser> getAllChefs(){
		return ud.getAllChefs();
	}
	
	public List<RUser> getAllDefaultUsers(){
		return ud.getAllNonChefs();
	}
	
	public String createUser(RUser user) {
		if (ud.createUser(user) > 0) {
			return "Success";
		} else {
			return "Failed";
		}
	}
	
	public RUser getUserByUserName(String username) {
		return ud.getUserByUserName(username);
	}
	
	public RUser updateUSer(RUser user) {
		return ud.updateUser(user);
	}
	
	public void deleteUser(RUser user) {
		ud.deleteUser(user);
	}
	
	public RUser authenticateUser(String userName, String pswd) {
		RUser user = ud.getUserByUserName(userName);
		if(user.getPswd().equals(pswd)) {
			return user;
		}
		
		return null;
	}
}
