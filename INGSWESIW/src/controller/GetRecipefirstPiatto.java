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

public class GetRecipefirstPiatto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> ricette=ricettaDao.findByCategory("primo");
		request.setAttribute("ricette", ricette);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/INGSWESIW/web/primi.jsp");
		dispatcher.forward(request,response);
	}



}
