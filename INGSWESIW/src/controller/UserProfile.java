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
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String UserId=request.getParameter("idUser");
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente=utenteDao.findByPrimaryKey(UserId);
		request.setAttribute("utente", utente);
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		List<Ricetta> myrecipes=ricettaDao.findAllPubblicateByUtente(utente);
		request.setAttribute("myrecipes", myrecipes);
		RequestDispatcher dispatcher=request.getRequestDispatcher("pages/profile.jsp");
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
