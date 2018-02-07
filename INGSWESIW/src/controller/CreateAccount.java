package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

public class CreateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 9140821607592123642L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
		dispacher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setEmail(email);
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		utenteDao.save(utente, password);
		request.setAttribute("utente", utente);
		// RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
		// dispacher.forward(request, response);
		response.sendRedirect("login.jsp");
	}

}
