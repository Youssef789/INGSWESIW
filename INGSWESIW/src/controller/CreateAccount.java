package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DAOFactory;
import persistence.DatabaseManager;
import persistence.UtilDao;
import persistence.dao.UtenteDao;


public class CreateAccount extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
		dispacher.forward(request, response);
		//PrintWriter out = response.getWriter();
		//out.print("hello");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {

		
			Utente utente = new Utente(name,username,email);

			UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			utenteDao.save(utente);
			utenteDao.setPassword(utente, password);
			
			request.setAttribute("utente", utente);
			
			//RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
			//dispacher.forward(request, response);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>create account</title></head>");
			out.println("<body>");
			out.println("<h1>hai creato account utente:</h1>");
			out.println("full name: "+name);
			out.println("username: "+username);
			out.println("Email: "+email);
			out.println("<a href=\"login.jsp\">click qui per effettuare il login</a>");
			out.println("</body>");
			out.println("</html>");	
			//response.sendRedirect("login.jsp");
			
		}
		catch (Exception e) {
		}
		
	}

}
