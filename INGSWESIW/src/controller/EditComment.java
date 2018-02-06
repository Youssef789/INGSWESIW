package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

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
 * Servlet implementation class EditComment
 */
@WebServlet("/EditComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private class JsonComment{		
		private String idComment;
		private String comment;		
	}
	
	@SuppressWarnings("unused")
	private class InfoComment{
		private String containComment;
		private Date dataUltimaModifica;
	}
	
    public EditComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idComment = request.getParameter("idComment");
		CommentoDao commentoDao=DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
		Commento commento= commentoDao.findByPrimaryKey(Long.parseLong(idComment));
		request.setAttribute("commento", commento.getContenuto());
		request.setAttribute("idComment", idComment);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/editComment.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentoDao commentoDao=DatabaseManager.getInstance().getDaoFactory().getCommentoDAO();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line =bufferedReader.readLine();
		JsonComment jsonComment=new Gson().fromJson(line, JsonComment.class);
		Commento comment=new Commento();
	    comment.setId(Long.parseLong(jsonComment.idComment));
	    comment.setContenuto(jsonComment.comment);
		commentoDao.update(comment);
		
		
		InfoComment infoComment = new InfoComment();
	    infoComment.containComment=comment.getContenuto();
	    infoComment.dataUltimaModifica = comment.getDataUltimaModifica();
		
		response.getWriter().write(new Gson().toJson(infoComment));
	}

}
