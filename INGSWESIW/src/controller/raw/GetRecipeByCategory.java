package controller.raw;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

public class GetRecipeByCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String type = request.getParameter("category");
		List<Ricetta> recipes = ricettaDao.findAllPubblicateByCategoria(Categoria.valueOf(type));
		request.setAttribute("recipes", recipes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/category.jsp");
		dispatcher.forward(request, response);
	}
	
}
