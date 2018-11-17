package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;


public class Follow extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private class Following{
		private String tipo;
		private String idUser;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Follow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String utenteUsername = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(utenteUsername);	
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		String userId =request.getParameter("idUser");
		//System.out.println(userId);
		Utente follower = utenteDao.findByPrimaryKey(userId);
		Utente folloing = utenteDao.findFollowing(utente, follower);
		//System.out.println(folloing);
		String message = null;
		if( folloing == null)
		{
			message = "true";
		} else {
			message = "false";
		}
		response.getWriter().write(message);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");
		Utente utente = new Utente();
		utente.setUsername(utenteUsername);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		Following following = new Gson().fromJson(bufferedReader.readLine(), Following.class);
		
		UtenteDao utenteDao =DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente follower = utenteDao.findByPrimaryKey(following.idUser);
		//System.out.println("io"+utente +" "+ follower);
		if(following.tipo.equals("add")) {
		utenteDao.insertFollowing(utente, follower);
		utenteDao.insertFollower(follower, utente);
		//System.out.println(utente );
		}
		if(following.tipo.equals("remove"))
		{
		utenteDao.deleteFollower(follower, utente);
		utenteDao.deleteFollowing(utente, follower);
		}
		response.getWriter().write("true");
	}

}
