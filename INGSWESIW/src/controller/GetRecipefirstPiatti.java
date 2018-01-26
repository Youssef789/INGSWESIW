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

public class GetRecipefirstPiatti extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> firsts=ricettaDao.findByCategory("primo");
		request.setAttribute("firsts", firsts);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/primi.jsp");
		dispatcher.forward(request,response);
	}



}
