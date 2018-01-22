package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

public class GetRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetRecipe() {
		 super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao =DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		List<Ricetta> recipes=ricettaDao.findAll();
		//Long recipeId=Long.parseLong((request.getParameter("id")));
		//Ricetta recipe= ricettaDao.findByPrimaryKey(recipeId);
		//request.setAttribute("recipes", recipes);
		String test="prova";
		request.setAttribute("prova", test);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request,response);
		
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<table border = 1");
//		out.println("<tr>");
//		out.println("<th>Matricola</th>");
//		out.println("<th>Nome</th>");
//		out.println("<th>Cognome</th>");
//		out.println("<th>Data di Nascita</th>");
//		out.println("<th>Indirizzo</th>");
//		out.println("</tr>");
//		for (Ricetta s : ricettaDao.findAll()){
//			out.println("<tr>");
//			out.println("<td>");
//			out.println(s.getTitle());
//			out.println("</td>");
//			out.println("<td>");
//			out.println(s.getCategory());
//			out.println("</td>");
//			out.println("<td>");
//			out.println(s.getDifficulty());
//			out.println("</td>");
//			out.println("<td>");
//			out.println(s.getDescription());
//			out.println("</td>");
//			out.println("<td>");
//			out.println(s.getIngredient());
//			out.println("</td>");
//			out.println("</tr>");
//		}
//		out.println("</table>");
//		out.println("</html>");
	
	}

	

}
