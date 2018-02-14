package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;

@WebServlet("/AddFavouriteRecipe")
public class AddFavouriteRecipe extends HttpServlet {
	
	private static final long serialVersionUID = 7186225855998223418L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usernameUtente = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(usernameUtente);
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String recipeId = request.getParameter("idRecipe");
		Ricetta ricetta = ricettaDao.findByPrimaryKey(Long.parseLong(recipeId));
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		utenteDao.insertRicettaPreferita(utente, ricetta);
		response.getWriter().write("true");
	}

}
