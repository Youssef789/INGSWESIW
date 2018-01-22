package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Ricetta;
import persistence.DatabaseManager;
import persistence.dao.RicettaDao;

/**
 * Servlet implementation class Recipe
 */
@WebServlet("/Recipe")
public class Recipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recipe() {
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
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
		String title =request.getParameter("title");
		String category=request.getParameter("category");
		//String image=request.getParameter("photo");
		String difficulty=request.getParameter("difficulty");
		String preparationTime=request.getParameter("preparationTime");
		String ingredient=request.getParameter("ingredient");
		String description=request.getParameter("description");
		String preparation=request.getParameter("preparation");
		//System.out.println(image);
		Ricetta ricetta=new Ricetta();
		ricetta.setTitle(title);
		//ricetta.setImage(inputStream);
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

}
