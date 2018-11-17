package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Commento;
import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
/**
 * Servlet implementation class comment
 */

public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private class JsonComment{		
		private String idRecipe;
		private String comment;		
	}
	
	@SuppressWarnings("unused")
	private class InfoComment{
		private Long id;
		private String username;
		private String containComment;
		private Date dataPubblicazione;
	}
	
    public Comment() {
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
		CommentoDao commentoDao=DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line =bufferedReader.readLine();
		JsonComment jsonComment=new Gson().fromJson(line, JsonComment.class);
		Ricetta recipe= ricettaDao.findByPrimaryKey(Long.parseLong(jsonComment.idRecipe));
		
		
		
	    Commento comment=new Commento();
	    comment.setRicetta(recipe);
	    comment.setUtente(utente);
	    comment.setContenuto(jsonComment.comment);
	    commentoDao.save(comment);
	   
	    InfoComment infoComment = new InfoComment();
	    infoComment.id=comment.getId();
	    infoComment.username=utente.getUsername();
	    infoComment.containComment=comment.getContenuto();
	    infoComment.dataPubblicazione = comment.getDataPubblicazione();
		
		response.getWriter().write(new Gson().toJson(infoComment));
	}

}
