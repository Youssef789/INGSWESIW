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
 * Servlet implementation class GetRecipeLeavened
 */
@WebServlet("/GetRecipeLeavened")
public class GetRecipeLievitati extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> lievitati=ricettaDao.findByCategory("lievitato");
		request.setAttribute("lievitati", lievitati);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/lievitati.jsp");
		dispatcher.forward(request,response);
	}

	

}
