package controller;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;


public class CreateAccount extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("account.html");
		dispacher.forward(request, response);
		//PrintWriter out = response.getWriter();
		//out.print("hello");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ITALIAN);
		Date date;
		
			Utente utente = new Utente(name,username,email);
			//utente.setBirthday(date);

			UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			utenteDao.save(utente);
			utenteDao.setPassword(utente, password);
			
			request.setAttribute("utente", utente);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("account.html");
			dispacher.forward(request, response);
//			response.setContentType("text/html");
//			
//			
//			PrintWriter out = response.getWriter();
//			out.println("<html>");
//			out.println("<head><title>Iscrizione studente</title></head>");
//			out.println("<body>");
//			out.println("<h1>Abbiamo iscritto il seguente studente:</h1>");
//			out.println(name);
//			out.println(username);
//			out.println(email);
//			out.println(birthday);
//			out.println(password);
//			out.println("</body>");
//			out.println("</html>");	
//			

		
	}

}
