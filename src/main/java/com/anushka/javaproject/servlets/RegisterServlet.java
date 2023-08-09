package com.anushka.javaproject.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.anushka.javaproject.dao.UserDao;
import com.anushka.javaproject.entities.User;
import com.anushka.javaproject.helper.FactoryProvider;


public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		
		try {
			
			String uName = request.getParameter("uName");
			String uEmail = request.getParameter("uEmail");
			String uPassword = request.getParameter("uPassword");
			int uPhone = Integer.parseInt(request.getParameter("uPhone"));
			String uAddress = request.getParameter("uAddress");
			
			
			//validation
			if(uName.isEmpty()) {
				out.println("Enter username");
			}
			else if(uEmail.isEmpty()) {
				out.println("Enter email id");
			}
			else if(uPassword.isEmpty()) {
				out.println("Enter password");
			}
			else if(uAddress.isEmpty()) {
				out.println("Enter address");
			}
			
	
			//adding user to db via UserDao... that thing we can do here also,
			//but to maintain layers and loose coupling for future changes, prefer dao
			User user= new User(uName, uEmail, uPassword, uPhone, uAddress, "normal");
			UserDao userDao= new UserDao(FactoryProvider.getFactory());
			int userId= userDao.addUser(user);
			System.out.println(userId);
			
			//session can store value for sometime..jbtk usko hta na do
			
			HttpSession httpSession= request.getSession();
			httpSession.setAttribute("message", "Registation successfull !!");
			
			response.sendRedirect("register.jsp");
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
