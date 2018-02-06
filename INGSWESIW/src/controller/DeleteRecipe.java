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
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

/**
 * Servlet implementation class DeleteRecipe
 */

public class DeleteRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private class romoveRecipe{		
		private String idRecipe;
		@SuppressWarnings("unused")
		private String remove;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		//String line =bufferedReader.readLine();
		//romoveRecipe jsonRecipe=new Gson().fromJson(line, romoveRecipe.class);
		String recipeId=request.getParameter("idRecipe");
		RicettaDao ricettaDao=DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		Ricetta recipe= ricettaDao.findByPrimaryKey(Long.parseLong(recipeId));
		ricettaDao.delete(recipe);
		response.getWriter().write("true");
	}

}
