package controller.raw;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
 * Servlet implementation class ApplyEditRecipe
 */
@WebServlet("/ApplyEditRecipe")
public class ApplyEditRecipe extends HttpServlet {
	private static final String SAVE_DIR="image";

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyEditRecipe() {
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
			request.setCharacterEncoding("UTF-8");
			String imagePath="C:/Users/my/git/INGSWESIW/INGSWESIW/WebContent/image" + File.separator + SAVE_DIR ;
	        Part filePart = request.getPart("photo");
	        String imageName=extracFilename(filePart);
	        filePart.write(imagePath + File.separator + imageName);
	        String recipeId=request.getParameter("idRecipe");
			Long id=Long.parseLong(recipeId);
	        String title =request.getParameter("title");
			String category=request.getParameter("category");
			String difficulty=request.getParameter("difficulty");
			String preparationTime=request.getParameter("preparationTime");
			String ingredient=request.getParameter("ingredient");
			String description=request.getParameter("description");
			String preparation=request.getParameter("preparation");
			imagePath=imagePath + File.separator + imageName;
			
			Ricetta ricetta=new Ricetta();
			ricetta.setId(id);
			ricetta.setTitolo(title);
			ricetta.setPathImmaginePrincipale(imageName);
			ricetta.setCategoria(Categoria.valueOf(category));
			ricetta.setDifficolta(Difficolta.valueOf(difficulty));
			ricetta.setTempoPreparazione(preparationTime);
			ricetta.setIngredienti(ingredient);
			ricetta.setDescrizione(description);
			ricetta.setPreparazione(preparation);
			RicettaDao ricettaDao=DatabaseManager.getInstance().getDaoFactory().getRicettaDAO();
			ricettaDao.updateAsPubblicata(ricetta);
			request.setAttribute("ricetta", ricetta);
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>ricetta</title></head>");
			out.println("<body>");
			out.println("<h1>hai modificato la tua ricetta</h1>");
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
