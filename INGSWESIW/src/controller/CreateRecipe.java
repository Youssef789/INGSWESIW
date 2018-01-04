package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

@MultipartConfig(maxFileSize=169999999)
public class CreateRecipe extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title =request.getParameter("title");
		String category=request.getParameter("category");
		//String image=request.getParameter("image");
		String difficulty=request.getParameter("difficulty");
		String preparationTime=request.getParameter("preparationTime");
		String ingredient=request.getParameter("ingredient");
		String description=request.getParameter("description");
		String preparation=request.getParameter("preparation");
		Part image =request.getPart("photo");
		//String content = request.getContentType();
		InputStream inputStream=null;
		if(image!=null)
		{
			long fileSize=image.getSize();
			String fileContent=image.getContentType();
			System.out.println(fileContent+fileSize);
			inputStream=image.getInputStream();
		}
		Ricetta ricetta=new Ricetta();
		ricetta.setTitle(title);
		ricetta.setImage(inputStream);
		ricetta.setCategory(category);
		ricetta.setDifficulty(difficulty);
		ricetta.setPreparationTime(preparationTime);
		ricetta.setIngredient(ingredient);
		ricetta.setDescription(description);
		ricetta.setPreparation(preparation);
		RicettaDao ricettaDao=DatabaseManager.getInstance().getDaoFactory().getRicrttaDAO();
		ricettaDao.save(ricetta);
		request.setAttribute("ricetta", ricetta);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>ricetta</title></head>");
		out.println("<body>");
		out.println("<h1>hai creato la tua ricetta:</h1>");
		out.println("</body>");
		out.println("</html>");	
	}

}
