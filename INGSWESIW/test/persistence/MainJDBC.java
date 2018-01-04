package persistence;


import java.util.Calendar;
import java.util.Date;

import model.Utente;
import persistence.dao.UtenteDao;

public class MainJDBC {
//ESERCIZIO (richiede Java8	
//	install Postgres https://www.postgresql.org/download/
//  scegliere utente: postgres -- password: postgres
//	
//	Lanciare PGADIMN oppure psql 
//	create database test;
//
//
//
//	- Vedere MainJDBC File.
//	- Testare i Dao Studente e Gruppo.
//	- Aggiungere l'entita' INDIRIZZO(codice, nome) per lo studente 
	//(uno studente ha un solo indirizzo)
//	- Aggiungere l'entita' CORSO(codice, nome), molti a molti con Studente.
	
	public static void main(String args[]) {
		

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();
		
		util.createDatabase();
	
		
		UtenteDao utenteDao = factory.getUtenteDAO();
		
		Utente utente1 = new Utente("mohamed youssef", "myousef7", "myousef@gmail.com");
		Utente utente2 = new Utente();
		utente2.setName("roumia");
		utente2.setUsername("myousef");
		utente2.setEmail("yousef@yahoo.com");
		
		utenteDao.save(utente1);
		utenteDao.save(utente2);
		utenteDao.setPassword(utente1, "123");
		utenteDao.setPassword(utente2, "012");
		
		System.out.println("Elenco studenti");
		for(Utente utente : utenteDao.findAll()) {
			System.out.println(utente);
		}

		
	}
}
