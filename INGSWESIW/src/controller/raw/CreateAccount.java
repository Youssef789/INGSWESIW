package controller.raw;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DAOFactory;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;
import persistence.UtilDao;


public class CreateAccount extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
		dispacher.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {

		
			Utente utente = new Utente();
			utente.setUsername(username);
			utente.setEmail(email);

			UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			utenteDao.save(utente, password);
			
			request.setAttribute("utente", utente);
			
			//RequestDispatcher dispacher = request.getRequestDispatcher("account.jsp");
			//dispacher.forward(request, response);

			response.sendRedirect("login.jsp");
			
		}
		catch (Exception e) {
		}
		
	}

}
