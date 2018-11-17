package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

@WebServlet("/AvailableUsername")
public class AvailableUsername extends HttpServlet {

	private static final long serialVersionUID = -521062902355556560L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente = utenteDao.findByPrimaryKey(username);
		String messaggio = null;
		if (utente == null) {
			messaggio = "true";
		} else {
			messaggio = "false";
		}
		response.getWriter().write(messaggio);
	}

}
