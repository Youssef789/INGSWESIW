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
import persistence.dao.jdbc.UtenteCredenziali;
import persistence.dao.UtenteDao;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = -3766426602998863542L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(username);
		if ( (utenteCredenziali != null) && (utenteCredenziali.getPassword().equals(password)) ) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			out.print(username);
			response.sendRedirect("AllRecipes");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}	
	}
	
}
