package test;

import model.Categoria;
import model.Commento;
import model.Difficolta;
import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.DAOFactory;
import persistence.UtilDao;
import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;
import persistence.dao.jdbc.UtenteCredenziali;

public class Test {
	
	public static void main(String args[]) {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		
		util.dropDatabase(); /* reset database... */
		util.createDatabase(); /* creazione database */
		
		////////////////////////
		// Stampe di debug... //
		////////////////////////
		
		System.out.println();
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");
		System.out.println("/////////////////////////");
	
		///////////////////////////
		// Inserimento utenti... //
		///////////////////////////
		 
		UtenteDao utenteDao = factory.getUtenteDAO();
		
		Utente utente1 = new Utente();
		utente1.setUsername("myousef");
		utente1.setEmail("yousef@yahoo.com");
		
		Utente utente2 = new Utente();
		utente2.setUsername("r0ckY909");
		utente2.setEmail("mmazza@gmail.com");
		utente2.setImmagineProfilo("immagineProfilo");
		
		Utente utente3 = new Utente();
		utente3.setUsername("CiccioPasticcio");
		utente3.setEmail("cpasticcio@gmail.com");
		
		utenteDao.save(utente1, "123");
		utenteDao.save(utente2, "456");
		utenteDao.save(utente3, "789");
		
		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
		
		for (Utente utente : utenteDao.findAll()) {
			System.out.println(utente); /* stampo utente */
			UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(utente.getUsername());
			System.out.println(utenteCredenziali); /* stampo utenteCredenziali */
			System.out.println();
		}
		
		System.out.println("Cerco \"CiccioPasticcio\"... " + utenteDao.findByPrimaryKey("CiccioPasticcio"));
		System.out.println("Cerco \"RenataLimbranata\"... " + utenteDao.findByPrimaryKey("RenataLimbranata"));
		System.out.println("Cerco \"mmazza@gmail.com\"... " + utenteDao.findByEmail("mmazza@gmail.com"));
	
		
		utente2.setEmail("ammazza@gmail.com");
		utenteDao.setPassword(utente3, "987");
		
		utenteDao.update(utente1);
		utenteDao.update(utente2);
		utenteDao.update(utente3);
		
		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
		
		for (Utente utente : utenteDao.findAll()) {
			System.out.println(utente); /* stampo utente */
			UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(utente.getUsername());
			System.out.println(utenteCredenziali); /* stampo utenteCredenziali */
			System.out.println();
		}

		////////////////////////////
		// Inserimento ricette... //
		////////////////////////////
		
		RicettaDao ricettaDao = factory.getRicettaDAO();
		
		Ricetta ricetta1 = new Ricetta();
		ricetta1.setTitolo("Impepata di cozze");
		ricetta1.setCategoria(Categoria.ANTIPASTI);
		ricetta1.setDifficolta(Difficolta.MEDIA);
		ricetta1.setUtente(utente1);
		
		Ricetta ricetta2 = new Ricetta();
		ricetta2.setTitolo("Sformatino di broccoli e salsiccia");
		ricetta2.setCategoria(Categoria.ANTIPASTI);
		ricetta2.setDifficolta(Difficolta.FACILE);
		ricetta2.setUtente(utente2);
		
		Ricetta ricetta3 = new Ricetta();
		ricetta3.setTitolo("Pasta alla carbonara");
		ricetta3.setCategoria(Categoria.PRIMI_PIATTI);
		ricetta3.setDifficolta(Difficolta.FACILE);
		ricetta3.setUtente(utente3);
		
		ricettaDao.saveAsPubblicata(ricetta1);
		ricettaDao.saveAsPubblicata(ricetta2);
		ricettaDao.saveAsPubblicata(ricetta3);
//		
//		System.out.println("Elenco ricette pubblicate presenti..." + "\n");
//		
//		for (Ricetta ricetta : ricettaDao.findAllPubblicate()) {
//			System.out.println(ricetta);
//		}
//		
//		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
//		
//		for (Utente utente : utenteDao.findAll()) {
//			System.out.println(utente); /* stampo utente */
//			UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(utente.getUsername());
//			System.out.println(utenteCredenziali); /* stampo utenteCredenziali */
//			System.out.println();
//		}
//		
//		System.out.println("Elenco ricette pubblicate presenti..." + "\n");
//		
//		for (Ricetta ricetta : ricettaDao.findAllPubblicate()) {
//			System.out.println(ricetta);
//		}
//		
//		/////////////////////////////
//		// Inserimento commenti... //
//		/////////////////////////////
//		
//		CommentoDao commentoDao = factory.getCommentoDAO();
//		
//		Commento commento1 = new Commento();
//		commento1.setContenuto("Che bella ricetta!");
//		commento1.setRicetta(ricetta2);
//		commento1.setUtente(utente1);
//		
//		Commento commento2 = new Commento();
//		commento2.setContenuto("La voglio fare anch'io prossimamente!");
//		commento2.setRicetta(ricetta1);
//		commento2.setUtente(utente2);
//		
//		Commento commento3 = new Commento();
//		commento3.setContenuto("Mi piace!");
//		commento3.setRicetta(ricetta3);
//		commento3.setUtente(utente3);
//		
//		commentoDao.save(commento1);
//		commentoDao.save(commento2);
//		commentoDao.save(commento3);
//		
//		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
//		
//		for (Commento commento : commentoDao.findAll()) {
//			System.out.println(commento);
//		}
//		
//		utenteDao.delete(utente1);
//		
//		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
//		
//		for (Utente utente : utenteDao.findAll()) {
//			System.out.println(utente); /* stampo utente */
//			UtenteCredenziali utenteCredenziali = utenteDao.findByPrimaryKeyCredential(utente.getUsername());
//			System.out.println(utenteCredenziali); /* stampo utenteCredenziali */
//			System.out.println();
//		}
//		
//		System.out.println("Elenco ricette pubblicate presenti..." + "\n");
//		
//		for (Ricetta ricetta : ricettaDao.findAllPubblicate()) {
//			System.out.println(ricetta);
//		}
//		
//		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
//		
//		for (Commento commento : commentoDao.findAll()) {
//			System.out.println(commento);
//		}
		
//		
//		/////////////////////////
//		// Inserimento voti... //
//		/////////////////////////
//		
//		VotoDao votoDao = factory.getVotoDAO();
//		
//		Voto voto1 = new Voto();
//		voto1.setId(new Long(1));
//		voto1.setValore(5);
//		voto1.setRicetta(ricetta1);
//		voto1.setUtente(utente1);
//		
//		Voto voto2 = new Voto();
//		voto2.setId(new Long(2));
//		voto2.setValore(5);
//		voto2.setRicetta(ricetta2);
//		voto2.setUtente(utente2);
//		
//		Voto voto3 = new Voto();
//		voto3.setId(new Long(3));
//		voto3.setValore(5);
//		voto3.setRicetta(ricetta3);
//		voto3.setUtente(utente1);
//		
//		votoDao.save(voto1);
//		votoDao.save(voto2);
//		votoDao.save(voto3);
//		

//		

//

//		
//		for (Utente utente : utenteDao.findAll()) {
//			System.out.println(utente);
//		}
//	
//		System.out.println("\n" + "Elenco ricette presenti..." + "\n");
//		
//		for (Ricetta ricetta : ricettaDao.findAll()) {
//			System.out.println(ricetta);
//		}
//		
//		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
//		
//		for (Commento commento : commentoDao.findAll()) {
//			System.out.println(commento);
//		}
//		
//		System.out.println("\n" + "Elenco voti presenti..." + "\n");
//		
//		for (Voto voto : votoDao.findAll()) {
//			System.out.println(voto);
//		}
//		
//		votoDao.delete(voto3);
//		
//		/////////////////////////
//		// Altre operazioni... //
//		/////////////////////////
//		
//		System.out.println();
//		System.out.println("/////////////////////////");
//		System.out.println("/////////////////////////");
//		System.out.println("/////////////////////////");
//		
//		voto2.setValore(4);
//		
//		commento2.setTesto("Ho modificato il commento");
//		
//		votoDao.update(voto2);
//		
//		commentoDao.update(commento2);
//		
//		System.out.println("\n" + "Ricerca di ricette tramite titolo..." + "\n");
//		
//		for (Ricetta ricettaFindByTitolo : ricettaDao.findByTitolo("impepata")) {
//			System.out.println(ricettaFindByTitolo);
//		}
//		
//		System.out.println("\n" + "Ricerca di ricette tramite categoria..." + "\n");
//		
//		for (Ricetta ricettaFindByCateroria : ricettaDao.findByCategoria(Categoria.ANTIPASTI)) {
//			System.out.println(ricettaFindByCateroria);
//		}
//		
//		System.out.println("\n" + "Ricerca di ricette tramite utente..." + "\n");
//		
//		for (Ricetta ricettaFindByUtente : ricettaDao.findByUtente(utente2)) {
//			System.out.println(ricettaFindByUtente);
//		}
//		 		
//		//////////////////////////////
//		// Altre stampe di debug... //
//		//////////////////////////////
//	
//		System.out.println("\n" + "Elenco utenti presenti..." + "\n");
//		
//		for (Utente utente : utenteDao.findAll()) {
//			System.out.println(utente);
//		}
//		
//		System.out.println("\n" + "Elenco ricette presenti..." + "\n");
//		
//		for (Ricetta ricetta : ricettaDao.findAll()) {
//			System.out.println(ricetta);
//		}
//		
//		System.out.println("\n" + "Elenco commenti presenti..." + "\n");
//		
//		for (Commento commento : commentoDao.findAll()) {
//			System.out.println(commento);
//		}
//		
//		System.out.println("\n" + "Elenco voti presenti..." + "\n");
//		
//		for (Voto voto : votoDao.findAll()) {
//			System.out.println(voto);
//		}

	}
		
}
