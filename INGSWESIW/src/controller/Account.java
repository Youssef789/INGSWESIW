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

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {

		
			Utente utente = new Utente(name,username,email);

			UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			utenteDao.save(utente);
			utenteDao.setPassword(utente, password);
			
			request.setAttribute("utente", utente);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("web/account.jsp");
			dispacher.forward(request, response);
			doGet(request, response);
		}
		catch (Exception e) {
		}
			
	}

}
