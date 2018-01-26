package persistence;

import model.Categoria;
import model.Commento;
import model.Difficolta;
import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;

public class MainJDBC {
	
	public static void main(String args[]) {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		
		util.dropDatabase();
		util.createDatabase();
	
		///////////////////////////
		// Inserimento utenti... //
		///////////////////////////
		 
		UtenteDao utenteDao = factory.getUtenteDAO();
		
		Utente utente1 = new Utente();
		utente1.setUsername("myousef");
		utente1.setEmail("yousef@yahoo.com");
		utente1.setPassword("111");
		
		Utente utente2 = new Utente();
		utente2.setUsername("r0ckY909");
		utente2.setEmail("mmazza@gmail.com");
		utente2.setPassword("111");

		utenteDao.save(utente1);
		utenteDao.save(utente2);
		
		////////////////////////////
		// Inserimento ricette... //
		////////////////////////////
		
		RicettaDao ricettaDao = factory.getRicettaDAO();
		
		Ricetta ricetta1 = new Ricetta();
		ricetta1.setId(new Long(1));
		ricetta1.setTitolo("Impepata di cozze");
		ricetta1.setCategoria(Categoria.ANTIPASTI);
		ricetta1.setDifficolta(Difficolta.MEDIA);
		
		Ricetta ricetta2 = new Ricetta();
		ricetta2.setId(new Long(2));
		ricetta2.setTitolo("Sformatino di broccoli e salsiccia");
		ricetta2.setCategoria(Categoria.ANTIPASTI);
		ricetta2.setDifficolta(Difficolta.FACILE);
		
		ricettaDao.save(ricetta1);
		ricettaDao.save(ricetta2);
		
		/////////////////////////////
		// Inserimento commenti... //
		/////////////////////////////
		
		CommentoDao commentoDao = factory.getCommentoDAO();
		
		Commento commento1 = new Commento();
		commento1.setId(new Long(1));
		commento1.setData(new java.util.Date());
		commento1.setTesto("Che bella ricetta!");
		commento1.setRicetta(ricetta2);
		commento1.setUtente(utente1);
		
		Commento commento2 = new Commento();
		commento2.setId(new Long(2));
		commento2.setData(new java.util.Date());
		commento2.setTesto("La voglio fare anch'io prossimamente!");
		commento2.setRicetta(ricetta1);
		commento2.setUtente(utente2);
		
		commentoDao.save(commento1);
		commentoDao.save(commento2);
		
		/////////////////////////
		// Inserimento voti... //
		/////////////////////////
		
		VotoDao votoDao = factory.getVotoDAO();
		
		Voto voto1 = new Voto();
		voto1.setId(new Long(1));
		voto1.setValore(5);
		voto1.setRicetta(ricetta1);
		voto1.setUtente(utente1);
		
		Voto voto2 = new Voto();
		voto2.setId(new Long(2));
		voto2.setValore(5);
		voto2.setRicetta(ricetta2);
		voto2.setUtente(utente2);
		
		votoDao.save(voto1);
		votoDao.save(voto2);
		
		////////////////////////
		// Stampe di debug... //
		////////////////////////
		
		System.out.println();
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");

		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
		
		for (Utente utente : utenteDao.findAll()) {
			System.out.println(utente);
		}
		
		System.out.println("\n" + "Elenco ricette presenti..." + "\n");
		
		for (Ricetta ricetta : ricettaDao.findAll()) {
			System.out.println(ricetta);
		}
		
		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
		
		for (Commento commento : commentoDao.findAll()) {
			System.out.println(commento);
		}
		
		System.out.println("\n" + "Elenco voti presenti..." + "\n");
		
		for (Voto voto : votoDao.findAll()) {
			System.out.println(voto);
		}
		
		/////////////////////////
		// Altre operazioni... //
		/////////////////////////
		
		voto2.setValore(4);
		
		votoDao.update(voto2);
 		
		//////////////////////////////
		// Altre stampe di debug... //
		//////////////////////////////
		
		System.out.println();
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");
		
		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
		
		for (Utente utente : utenteDao.findAll()) {
			System.out.println(utente);
		}
		
		System.out.println("\n" + "Elenco ricette presenti..." + "\n");
		
		for (Ricetta ricetta : ricettaDao.findAll()) {
			System.out.println(ricetta);
		}
		
		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
		
		for (Commento commento : commentoDao.findAll()) {
			System.out.println(commento);
		}
		
		System.out.println("\n" + "Elenco voti presenti..." + "\n");
		
		for (Voto voto : votoDao.findAll()) {
			System.out.println(voto);
		}

	}
	
}
