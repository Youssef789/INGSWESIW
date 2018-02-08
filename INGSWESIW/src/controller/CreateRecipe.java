package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Categoria;
import model.Difficolta;
import model.Ricetta;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;

@MultipartConfig
public class CreateRecipe extends HttpServlet {
	
	private static final long serialVersionUID = -634630766728256779L;
	
	private static final String SAVE_DIR="C:\\Users\\Manuel\\git\\INGSWESIW\\INGSWESIW\\WebContent\\imageNames"; /* da cambiare assolutamente! */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/////////////////////////////////////////
		/////////////////////////////////////////
		/////////////////////////////////////////
		
	    Part filePart = request.getPart("photo");
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
	    
        filePart.write(SAVE_DIR + File.separator + fileName);
        
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

		String username = (String) request.getSession().getAttribute("username");
		
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente = utenteDao.findByPrimaryKey(username);
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String difficulty = request.getParameter("difficulty");
		String preparationTime = request.getParameter("preparationTime");
		String ingredient = request.getParameter("ingredient");
		String description = request.getParameter("description");
		String preparation = request.getParameter("preparation");
		
		Ricetta ricetta = new Ricetta();
		
		ricetta.setUtente(utente);
		ricetta.setTitolo(title);
		ricetta.setNameImmaginePrincipale(fileName);
		ricetta.setCategoria(Categoria.valueOf(category));
		ricetta.setDifficolta(Difficolta.valueOf(difficulty));
		ricetta.setTempoPreparazione(preparationTime);
		ricetta.setIngredienti(ingredient);
		ricetta.setDescrizione(description);
		ricetta.setPreparazione(preparation);
		ricetta.setUtente(utente);
		
		RicettaDao ricettaDao = DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
		ricettaDao.saveAsPubblicata(ricetta);
		
		request.setAttribute("ricetta", ricetta);
		response.sendRedirect("AllRecipes");
		
	}
	
}
