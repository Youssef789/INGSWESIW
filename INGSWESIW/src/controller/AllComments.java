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
import persistence.CommentoDao;
import persistence.DatabaseManager;
import persistence.RicettaDao;

/**
 * Servlet implementation class GetComments
 */
@WebServlet("/AllComments")
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
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		String recipeId=request.getParameter("idRecipe");
		Long id=Long.parseLong(recipeId);
		Ricetta recipe= ricettaDao.findByPrimaryKey(id);
		CommentoDao commentoDao=DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
		List<Commento> comments=commentoDao.findByRicetta(recipe);
		request.setAttribute("comments", comments);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/displayRecipe.jsp");
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
