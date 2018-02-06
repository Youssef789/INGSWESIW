package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commento;
import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;

/**
 * Servlet implementation class GetComments
 */

public class AllComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(utenteUsername);
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		Long id=Long.parseLong(request.getParameter("idRecipe"));
		Ricetta recipe= ricettaDao.findByPrimaryKey(id);
		request.setAttribute("comments", recipe.getCommenti());
		request.setAttribute("utente", utente);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/allcomments.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
