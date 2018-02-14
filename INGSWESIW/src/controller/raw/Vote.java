package controller.raw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.VotoDao;

/**
 * Servlet implementation class Vote
 */

public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private class JsonVote{		
		private String idRecipe;
		private Integer value;		
	}
    public Vote() {
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
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(utenteUsername);
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		VotoDao votoDao=DatabaseManager.getInstance().getDaoFactory().getVotoDAO();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line =bufferedReader.readLine();
		JsonVote jsonVote=new Gson().fromJson(line, JsonVote.class);
		Ricetta recipe= ricettaDao.findByPrimaryKey(Long.parseLong(jsonVote.idRecipe));
		
		Voto voto =new Voto();
		voto.setRicetta(recipe);
		voto.setUtente(utente);
		voto.setValore(jsonVote.value);
		votoDao.save(voto);
		response.getWriter().write("true");
		
//		Utente utente = (Utente) request.getSession().getAttribute("username");
//		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
//		String recipeId = request.getParameter("idRecipe");
//		Long id = Long.parseLong(recipeId);
//		Ricetta recipe = ricettaDao.findByPrimaryKey(id);
//		String votoInserito = request.getParameter("selected");
//		Integer valore = Integer.parseInt(votoInserito);
//	    Voto vote = new Voto();
//	    vote.setRicetta(recipe);
//	    vote.setUtente(utente);
//	    vote.setValore(valore);
//	    VotoDao votoDao = DatabaseManager.getInstance().getDaoFactory().getVotoDAO();
//	    votoDao.save(vote);
//	    response.getWriter().write("true");
	 
	}

}
