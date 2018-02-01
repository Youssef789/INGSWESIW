package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.RicettaDao;

/**
 * Servlet implementation class GetVotes
 */
@WebServlet("/GetVotes")
public class GetVotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		String recipeId=request.getParameter("idRecipe");
		Long id=Long.parseLong(recipeId);
		//Ricetta recipe= ricettaDao.findByPrimaryKey(id);
		//Long votoComplessivo= recipe.getVotoComplessivo();
		//request.setAttribute("votoComplessivo", votoComplessivo);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/displayRecipe.jsp");
		dispatcher.forward(request,response);
	}

}
