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
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

/**
 * Servlet implementation class GetRecipeUniqDishes
 */

public class GetRecipeUniqDishes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> uniqueDishes=ricettaDao.findByCategory("piattoUnico");
		request.setAttribute("uniqueDishes", uniqueDishes);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/piattiUnici.jsp");
		dispatcher.forward(request,response);
	}

	

}
