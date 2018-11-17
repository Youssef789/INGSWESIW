package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

/**
 * Servlet implementation class LoginByFB
 */
@WebServlet("/LoginByFB")
public class LoginByFB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginByFB() {
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
		HttpSession session = request.getSession();
		Utente user = (Utente) session.getAttribute("username");
		if(user == null)
		{
			String username=request.getParameter("name");
			UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			user = utenteDao.findByPrimaryKey(username);
			if(user != null) {
				session.setAttribute("username",username);
				response.sendRedirect("AllRecipes");
			}else {
				String email = request.getParameter("email");
				String password = request.getParameter("passwordfb");

				Utente utente = new Utente();
				utente.setUsername(username);
				utente.setEmail(email);
				utenteDao.save(utente, password);
				session.setAttribute("username",username);
				response.sendRedirect("AllRecipes");
			}
			
		}
		else {
			response.sendRedirect("AllRecipes");
			session.setAttribute("username",user);

		}
	}
	

}
