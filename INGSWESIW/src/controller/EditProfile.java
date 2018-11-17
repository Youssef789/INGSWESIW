package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;
import persistence.dao.jdbc.UtenteCredenziali;


public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String utenteUsername = (String) request.getSession().getAttribute("username");	
		Utente utente = new Utente();
		UtenteDao utenteDao= DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		utente=utenteDao.findByPrimaryKey(utenteUsername);
		UtenteCredenziali utenteCredenziali= utenteDao.findByPrimaryKeyCredential(utenteUsername);
		String utentePassword = utenteCredenziali.getPassword();
		request.setAttribute("utente", utente);
		request.setAttribute("utentePassword", utentePassword);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/editprofile.jsp");
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente= new Utente();
		utente.setUsername(username);
		utente.setEmail(email);
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		utenteDao.update(utente);
		utenteDao.setPassword(utente, password);
	}

}
