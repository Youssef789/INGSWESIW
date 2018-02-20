package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;


public class Favorites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorites() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente = utenteDao.findByPrimaryKey(utenteUsername);

		List<Ricetta> ricette = utente.getRicettePreferite();
//		for (Ricetta ricetta : ricette) {
//			System.out.println(ricetta.toString());
//		}
//		
//		System.out.println(ricette.size());
		request.setAttribute("ricette", ricette);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/favorites.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
