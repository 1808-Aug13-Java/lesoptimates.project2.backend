package com.revature.eval.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.dao.RecipeDao;
import com.revature.dao.RecipeDaoImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
/**
 * This Junit test will confirm whether or not all DAO methods are behaving as expected 
 * @author jeremiah
 *
 */
public class DOATest {

	private static final UserDAO evaluationUserDao = new UserDAOImpl();
	private static final RecipeDao evaluationRecipeDao = new RecipeDaoImpl();
	private static Logger log = Logger.getRootLogger();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/*
	 * Hardcoded test case will only work with newly created database
	 */
	@Test
	public void testGetRecipes() {
		/*
		 * will have to manually ensure that the passed id's will match these expected objects
		 */
//		expResult.add(new Employee(120, "Lindsey", "Gilluley", 100, "Bryum"));
//		expResult.add(new Employee(121, "Cecelia", "Woodroffe", 101, "Vernonia"));
//		expResult.add(new Employee(122, "Brandea", "McSperron", 102, "Echinocereus"));
//		expResult.add(new Employee(123, "Owen", "Templeton", 103, "Triplaris"));
//		expResult.add(new Employee(124, "Tracie", "Runchman", 104, "Randia"));

//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}

	}

	@Test
	public void testGetRecipesByUser() {
//		List<Employee> returnedResult = evaluationEmplDao.getEmployeesByManId(100);
//		List<Employee> expResult = new ArrayList<Employee>();
//
//		expResult.add(new Employee(120, "Lindsey", "Gilluley", 100, "Bryum"));
//
//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}
	}

	@Test
	public void testGetRecipeById() {
//		Employee expectedResult = new Employee(120, "Lindsey", "Gilluley", 100, "Bryum");
//		Employee returnedResult = evaluationEmplDao.getEmployeeById(120);
//
//		assertEquals(expectedResult, returnedResult);
	}

	@Test
	public void testUpdateRecipe() {

	}

	@Test
	public void testCreateRecipe() throws IOException, SQLException {
		/*
		 * username is generated by a stored procedure that concats the first name with the primary key created
		 * on insert. this means the fields id and username need to be manually set to what the database will create
		 */
//		Employee expectedResult = new Employee(105, "Lindsey", "Gilluley", 100, "Bryum", "Lindsey105");
//		
//		
//		assertEquals(2, evaluationEmplDao.createEmployee(expectedResult, con));

	}

	@Test
	public void testDeleteRecipe() {

	}

	@Test
	public void testGetAllUsers() throws ParseException {
//		List<Reimbursment> returnedResult = evaluationReimbDao.getReimbursments();
//		List<Reimbursment> expResult = new ArrayList<Reimbursment>();
//
//		expResult.add(new Reimbursment(123, 120, "pending", "travel - less than 50", 0));
//		expResult.add(new Reimbursment(124, 121, "pending", "Training", 0));
//		expResult.add(new Reimbursment(125, 121, "resolved",
//				"Supplies - max of 60", 101));
//
//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}
	}

	@Test
	public void testGetAllChefUSers() throws ParseException {

//		Reimbursment expectedResult = new Reimbursment(123, 120, "pending", "travel - less than 50", 0);
//		Reimbursment returnedResult = evaluationReimbDao.getReimbursmentById(123);
//
//		assertEquals(expectedResult, returnedResult);
	}
	
	@Test
	public void testGetAllNonChefUsers() throws ParseException {
//		List<Reimbursment> returnedResult = evaluationReimbDao.getReimbursmentByEmpId(121);
//		List<Reimbursment> expResult = new ArrayList<Reimbursment>();
//
//		expResult.add(new Reimbursment(124, 121, "pending", "Training", 0));
//		expResult.add(new Reimbursment(125, 121, "resolved", "Supplies - max of 60", 101));
//
//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}
	}

	@Test
	public void testGetUserByUserName() {
//		List<Reimbursment> returnedResult = evaluationReimbDao.getReimbursmentByManId(101);
//		List<Reimbursment> expResult = new ArrayList<Reimbursment>();
//
//		expResult.add(new Reimbursment(125, 121, "resolved", "Supplies - max of 60", 101));
//
//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}
	}

	@Test
	public void testCreateUser() {
//		List<Reimbursment> returnedResult = evaluationReimbDao.getReimbursmentByStatus("pending");
//		List<Reimbursment> expResult = new ArrayList<Reimbursment>();
//
//		expResult.add(new Reimbursment(123, 120, "pending", "travel - less than 50", 0));
//		expResult.add(new Reimbursment(124, 121, "pending", "Training", 0));
//
//		for (int i = 0; i < expResult.size(); i++) {
//			assertTrue(returnedResult.get(i).equals(expResult.get(i)));
//		}
	}

	@Test
	public void testUpdateUser() {

	}

	@Test
	public void testDeleteUSer() {

	}
	

}
