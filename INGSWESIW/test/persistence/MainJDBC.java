package persistence;

import model.Utente;
import persistence.dao.UtenteDao;

public class MainJDBC {
	
	public static void main(String args[]) {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		
		util.dropDatabase();
		util.createDatabase();
	
		////////////
		// Utenti //
		////////////
		
		UtenteDao utenteDao = factory.getUtenteDAO();
		
		Utente utente1 = new Utente();
		utente1.setUsername("myousef");
		utente1.setEmail("yousef@yahoo.com");
		utente1.setPassword("123");
		
		Utente utente2 = new Utente();
		utente2.setUsername("r0ckY909");
		utente2.setEmail("mmazza@gmail.com");
		utente2.setPassword("321");

		utenteDao.save(utente1);
		utenteDao.save(utente2);

		System.out.println("Elenco utenti");
		
		for (Utente utente : utenteDao.findAll()) {
			System.out.println(utente);
		}

	}
	
}
