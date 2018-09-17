package com.revature.dao;

import java.util.List;

import com.revature.models.RUser;

public interface CustomerDAO {

	public List<RUser> getAllUsers();
	public List<RUser> getAllChefs();
	public List<RUser> getAllNonChefs();
	public RUser getUserByUserName();
	public void createUser(RUser user);
	public void deleteUser(RUser user);
	public void updateUser(RUser user);
	
	
	
}
