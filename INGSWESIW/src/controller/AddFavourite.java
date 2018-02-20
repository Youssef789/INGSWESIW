package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;



public class AddFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private class Favourite{		
		private String tipo;
		private String idRecipe;
	}
	
    public AddFavourite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String utenteUsername = (String) request.getSession().getAttribute("username");
//		Utente utente = new Utente();
//		utente.setUsername(utenteUsername);		
//		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
//		String recipeId =request.getParameter("idRecipe");
//		Ricetta ricetta =ricettaDao.findByPrimaryKey(Long.parseLong(recipeId));
//		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
//		Ricetta ricettapreferita=utenteDao.findRicettaPreferita(utente,ricetta);
//		String utente_username= ricettapreferita.getUtente().getUsername();
//		Long ricetta_id =ricettapreferita.getId();
//		//System.out.println(utente_username+ricetta_id);
//		
//		request.setAttribute("utente_username", utente_username);
//		request.setAttribute("ricetta_id", ricetta_id);
//		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/displayRecipe.jsp");
//		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(utenteUsername);
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//		Favourite favourite = new Gson().fromJson(bufferedReader.readLine(), Favourite.class);
//		
//		RicettaDao ricettaDao=DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
//		Ricetta ricetta = ricettaDao.findByPrimaryKey(Long.parseLong(favourite.idRecipe));
//		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
//
//		if(favourite.tipo.equals("add"))
//		utenteDao.insertRicettaPreferita(utente,ricetta);
//		if(favourite.tipo.equals("remove"))
//		utenteDao.deleteRicettaPreferita(utente,ricetta);
//		response.getWriter().write("true");

		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String recipeId =request.getParameter("idRecipe");
		Ricetta ricetta =ricettaDao.findByPrimaryKey(Long.parseLong(recipeId));
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		utenteDao.insertRicettaPreferita(utente,ricetta);
		response.getWriter().write("true");
	}

}
