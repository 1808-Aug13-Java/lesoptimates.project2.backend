package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.RUser;
import com.revature.util.HibernateUtil;

public class UserDAOImpl implements UserDAO{

	private static Logger log = Logger.getRootLogger();

	@Override
	public List<RUser> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<RUser> users = s.createQuery("from RUser").list();
		s.close();
		return users;
	}

	@Override
	public List<RUser> getAllChefs() {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(RUser.class);
		cr.add(Restrictions.eq("isChef", 1));
		List<RUser> users = cr.list();
		s.close();
		return users;
	}

	@Override
	public List<RUser> getAllNonChefs() {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(RUser.class);
		cr.add(Restrictions.eq("isChef", 0));
		List<RUser> users = cr.list();
		s.close();
		return users;
	}

	@Override
	public RUser getUserByUserName(String userName) {
		Session s = HibernateUtil.getSession();
		Criteria cr = s.createCriteria(RUser.class);
		cr.add(Restrictions.eq("uName", userName));
//		RUser user = cr.;
		s.close();
		return null;
	}

	@Override
	public int createUser(RUser user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int custId = (Integer) s.save(user);
		tx.commit();
		s.close();
		return custId;
		
	}

	@Override
	public void deleteUser(RUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(RUser user) {
		// TODO Auto-generated method stub
		
	}

}
