package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.DatabaseManager;
import persistence.UtenteCredenziali;
import persistence.dao.UtenteDao;


public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
		dispacher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//session.setAttribute("email", null);
		//System.out.println("post");

		PrintWriter out = response.getWriter();
		String email= request.getParameter("email");
		String password= request.getParameter("password");

		UtenteDao dao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		if(dao.checkLogin(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",email);
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Login</title></head>");
			out.println("<body>");
			out.println(email);
			out.println("<h1>Login effettuato con successo</h1>");			
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("index.jsp");
		}else {
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Login</title></head>");
			out.println("<body>");
			out.println("<h1>email or passwrod is not correct</h1>");	
			out.println("<a href=\"login.jsp\">click here for login</a>");
			out.println("</body>");
			out.println("</html>");
			//response.sendRedirect("login.jsp");

	
		
	}
		
	}
		



}
