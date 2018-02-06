package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
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
import persistence.dao.RicettaDao;
import persistence.dao.CommentoDao;

/**
 * Servlet implementation class DeleteComment
 */
@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private class romoveComment{		
		private String idComment;
		@SuppressWarnings("unused")
		private String remove;
	}
	
    public DeleteComment() {
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
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line =bufferedReader.readLine();
		romoveComment jsonComment=new Gson().fromJson(line, romoveComment.class);
		
		CommentoDao commentoDao=DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
		Commento comment= commentoDao.findByPrimaryKey(Long.parseLong(jsonComment.idComment));
		commentoDao.delete(comment);
		response.getWriter().write("true");
	
	}

}
