package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Categoria;
import model.Difficolta;
import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

/**
 * Servlet implementation class EditRecipe
 */
@MultipartConfig
@WebServlet("/EditRecipe")
public class EditRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String SAVE_DIR="C:\\Users\\my\\git\\INGSWESIW\\INGSWESIW\\WebContent\\imageNames";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRecipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		String recipeId = request.getParameter("idRecipe");
		Ricetta recipe = ricettaDao.findByPrimaryKey(Long.parseLong(recipeId));
		request.setAttribute("recipe", recipe);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/editRecipe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String appPath = request.getServletContext().getRealPath("imageNames");
        Part filePart = request.getPart("photo");
	    String imageName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 

		//System.out.println(appPath + File.separator + imageName);

        filePart.write( appPath + File.separator + imageName);

        String recipeId=request.getParameter("idRecipe");
        String title =request.getParameter("title");
		String category=request.getParameter("category");
		String difficulty=request.getParameter("difficulty");
		String preparationTime=request.getParameter("preparationTime");
		String ingredient=request.getParameter("ingredient");
		String description=request.getParameter("description");
		String preparation=request.getParameter("preparation");
		
		Ricetta ricetta=new Ricetta();
		ricetta.setId(Long.parseLong(recipeId));
		ricetta.setTitolo(title);
		ricetta.setNameImmaginePrincipale(imageName);
		ricetta.setCategoria(Categoria.valueOf(category));
		ricetta.setDifficolta(Difficolta.valueOf(difficulty));
		ricetta.setTempoPreparazione(preparationTime);
		ricetta.setIngredienti(ingredient);
		ricetta.setDescrizione(description);
		ricetta.setPreparazione(preparation);
		RicettaDao ricettaDao=DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		ricettaDao.updateAsPubblicata(ricetta);
		request.setAttribute("ricetta", ricetta);
		response.sendRedirect("MyRecipes");
	}
	
	

}
