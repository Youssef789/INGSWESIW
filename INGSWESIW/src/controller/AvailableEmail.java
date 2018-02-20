package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

public class AvailableEmail extends HttpServlet {

	private static final long serialVersionUID = -7679277010948454112L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("charset=UTF-8");
		String email = request.getParameter("email");
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente = utenteDao.findByEmail(email);
		String message = null;
		if (utente == null) {
			message = "true";
		} else {
			message = "false";
		}
		response.getWriter().write(message);
	}

}

