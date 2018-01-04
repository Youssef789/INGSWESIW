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
@WebServlet("/GetRecipeUniqDishes")
public class GetRecipeUniqDishes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> ricette=ricettaDao.findByCategory("piatto_unico");
		request.setAttribute("ricette", ricette);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/INGSWESIW/web/piattiUnici.jsp");
		dispatcher.forward(request,response);
	}

	

}
