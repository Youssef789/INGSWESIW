package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

public class CreateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 9140821607592123642L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente = utenteDao.findByPrimaryKey(username);
		if (utente == null) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			utente = new Utente();			
			utente.setUsername(username);
			utente.setEmail(email);
			utenteDao.save(utente, password);
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			session.setAttribute("username", username);
			out.print(username);
			response.sendRedirect("AllRecipes");
		} else {
			RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
			dispacher.forward(request, response);
		}
	}

}
