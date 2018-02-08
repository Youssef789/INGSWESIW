package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

public class GetRecipe extends HttpServlet {
	
	private static final long serialVersionUID = -6722657022842066091L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String recipeId = request.getParameter("idRecipe");
		Long id = Long.parseLong(recipeId);
		Ricetta recipe= ricettaDao.findByPrimaryKey(id);
		request.setAttribute("recipe", recipe);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/displayRecipe.jsp");
		dispatcher.forward(request,response);
	}

}
