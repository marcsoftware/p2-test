package com.wcg.angular.backend;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import com.revature.dao.*;


@WebServlet("/formServlet")
public class FormServlet extends HttpServlet {

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

			/**** Preparing The Output Response ****/
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("Welcome " + user_name + " !!");
			saveName(user_name,"harcode");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	public void saveName(String user, String password){
		//String user = request.getParameter("user");
		//String password = request.getParameter("password");
		DataManager session = new DataManager();
		session.connect();
		Boolean result = session.register(user,password);

	}



}