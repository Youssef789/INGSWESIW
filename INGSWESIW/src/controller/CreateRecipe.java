package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.org.apache.regexp.internal.recompile;

import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
@MultipartConfig
public class CreateRecipe extends HttpServlet {
	private static final String SAVE_DIR="image";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		request.setCharacterEncoding("UTF-8");
		Utente utente = (Utente) request.getSession().getAttribute("username");
        String imagePath="C:/Users/my/git/INGSWESIW/INGSWESIW/WebContent/image" + File.separator + SAVE_DIR ;
        Part filePart = request.getPart("photo");
        String imageName=extracFilename(filePart);
        filePart.write(imagePath + File.separator + imageName);
		String title =request.getParameter("title");
		String category=request.getParameter("category");
		String difficulty=request.getParameter("difficulty");
		String preparationTime=request.getParameter("preparationTime");
		String ingredient=request.getParameter("ingredient");
		String description=request.getParameter("description");
		String preparation=request.getParameter("preparation");
		imagePath=imagePath + File.separator + imageName;
		Ricetta ricetta=new Ricetta();
		ricetta.setUtente(utente);
		ricetta.setTitle(title);
		ricetta.setImageName(imageName);
		ricetta.setImagePath(imagePath);
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
		out.println("<h1>hai creato la tua ricetta</h1>");
		out.println("</body>");
		out.println("</html>");	
	}


	private String extracFilename(Part filePart) {
		String contentDisp = filePart.getHeader("content-disposition");
		String [] items =contentDisp.split(";");
		for (String string : items) {
			if(string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=")+2, string.length() -1);
			}
		}
		return " ";
	}

}
