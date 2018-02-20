package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import persistence.DatabaseManager;
import persistence.dao.UtenteDao;
import persistence.dao.jdbc.UtenteCredenziali;


public class Login extends HttpServlet {
	
//	private class User{
//		private String username;
//		private String passwrod;
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispacher = request.getRequestDispatcher("pages/login.jsp");
//		dispacher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		PrintWriter out = response.getWriter();
//		String username= request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
//		
//		UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(username);
//		
//		if(utenteCredenziali.getPassword().equals(password)) {
//			HttpSession session = request.getSession();
//			session.setAttribute("username",username);
//			out.print(username);
//			response.sendRedirect("AllRecipes");
//			//RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//			//dispatcher.forward(request,response);
//		}else {
//			RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
//			dispatcher.forward(request,response);
//	}
//		
//	}
		String username= request.getParameter("username");
		String password = request.getParameter("password");

	UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
	UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(username);
	if(utenteCredenziali != null && utenteCredenziali.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			response.getWriter().write("true");
			//response.sendRedirect("AllRecipes");
	}else {
		response.getWriter().write("false");
	}
	
	}
	
	


}
