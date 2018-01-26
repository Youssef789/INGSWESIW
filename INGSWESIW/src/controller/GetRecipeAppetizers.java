package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;


public class GetRecipeAppetizers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> apperizers=ricettaDao.findByCategory("antipasto");
		request.setAttribute("apperizers", apperizers);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/antipasti.jsp");
		dispatcher.forward(request,response);
	}

	
}
