package com.revature.dao;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.json.JSONObject;
import com.revature.dao.*;
import com.revature.dao.domain.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**** This Method Is Called By The Servlet Container To Process A 'POST' Request. ****/
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		String str = null;	
		StringBuffer sb = null;
		JSONObject jObj = null;
		BufferedReader br = null;

		try {					
			br = req.getReader();
			sb = new StringBuffer();

			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			jObj = new JSONObject(sb.toString());
			String user_name = jObj.getString("username");
			String password = jObj.getString("password");

			/**** Preparing The Output Response ****/
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("You are logged in?:  " + user_name + " !!");
			hSaveName(user_name,password);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	

	//save name with hibernate
	public void hSaveName(String user_string, String password_string){
		
		
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
			
			// Create a session
			Session session = sessionFactory.openSession();
			
		

	

		//---------------------------------
		// Query - write parameterized HQL and native SQL
		List<User> record = session.createQuery("from User where username = :varName and password = :varPassword")
		.setString("varName", user_string).setString("varPassword",password_string)
		.list();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(";;;"+record);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
/*
		// Criteria - programmatic SELECT statement
		movies = session.createCriteria(User.class)
		.add(Restrictions.between("id", 2, 10))
		.addOrder(Order.desc("username"))
		.list();

		// Persist movie from DB to Java object
		User jurassicPark = (User) session.get(User.class, 1);
		System.out.println(jurassicPark);
*/
		session.close();
		sessionFactory.close();
		//---------------------------
	


		

	}


}