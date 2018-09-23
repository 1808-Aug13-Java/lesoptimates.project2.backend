package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.RUser;

public class UserService {
	
	private static Logger log = Logger.getRootLogger();
	private static UserDAO ud = new UserDAOImpl();
	public UserService() {
		super();
	}
	
	public List<RUser> getAllUsers(){
		return ud.getAllUsers();
	}
	
	public List<RUser> getAllUsersExternal(){
		List<RUser> users = ud.getAllUsers();
		List<RUser> sanatizedUsers = new ArrayList<>();
		
		for(RUser u: users) {
			u.setEmail(" ");
			u.setPswd(" ");
			u.setName(" ");
			sanatizedUsers.add(u);
			}
		
		return users;
	}
	
	public List<RUser> getAllChefs(){
		List<RUser> users = ud.getAllChefs();
		List<RUser> sanatizedUsers = new ArrayList<>();
		
		for(RUser u: users) {
			u.setEmail(" ");
			u.setPswd(" ");
			u.setName(" ");
			sanatizedUsers.add(u);
			}
		
		return users;
	}
	
	public List<RUser> getAllDefaultUsers(){
		List<RUser> users = ud.getAllNonChefs();
		List<RUser> sanatizedUsers = new ArrayList<>();
		
		for(RUser u: users) {
			u.setEmail(" ");
			u.setPswd(" ");
			u.setName(" ");
			sanatizedUsers.add(u);
			}
		
		return users;
	}
	
	public RUser createUser(RUser user) {
		int userId = ud.createUser(user);
		if (userId > 0) {
			return ud.getUserByUserId(userId);
		} else {
			return null;
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
