package com.anushka.javaproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;

import org.hibernate.Session;

import com.anushka.javaproject.dao.UserDao;
import com.anushka.javaproject.entities.User;
import com.anushka.javaproject.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		
		try {
			
			//extract data
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			
			//validation
			
			//authentication
			UserDao uDao= new UserDao(FactoryProvider.getFactory());
			User user= uDao.getUser(email, password);
			
			HttpSession httpSession= request.getSession();
			
			if(user==null) {
				httpSession.setAttribute("message", "Invalid credentials !!");
				response.sendRedirect("login.jsp");
				return;
			}
			else {
				httpSession.setAttribute("current-user", user);
				if(user.getuType().equals("admin"))
					response.sendRedirect("admin.jsp");
				else if(user.getuType().equals("normal"))
					response.sendRedirect("normal.jsp");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
