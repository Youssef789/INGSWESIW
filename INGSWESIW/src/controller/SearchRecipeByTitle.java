package controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

@WebServlet("/SearchRecipeByTitle")
public class SearchRecipeByTitle extends HttpServlet {
	
	private static final long serialVersionUID = 3965963825891244533L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String search = request.getParameter("search");
		Set<Ricetta> result = ricettaDao.findAllPubblicateByTitolo(search);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/search.jsp");
		dispatcher.forward(request, response);
	}

}
