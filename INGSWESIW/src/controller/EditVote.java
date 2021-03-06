package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commento;
import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.VotoDao;
import persistence.dao.CommentoDao;

/**
 * Servlet implementation class EditVote
 */
@WebServlet("/EditVote")
public class EditVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVote() {
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
		Utente utente = (Utente) request.getSession().getAttribute("username");
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String recipeId=request.getParameter("idRecipe");
		Long id=Long.parseLong(recipeId);
		Ricetta recipe= ricettaDao.findByPrimaryKey(id);
		String votoInserito=request.getParameter("voto");
		Integer valore=Integer.parseInt(votoInserito);
	    Voto vote=new Voto();
	    vote.setRicetta(recipe);
	    vote.setUtente(utente);
	    vote.setValore(valore);
	    VotoDao votoDao=DatabaseManager.getInstance().getDaoFactory().getVotoDAO();
	    votoDao.update(vote);
	    request.setAttribute("vote", vote);
	}

}
