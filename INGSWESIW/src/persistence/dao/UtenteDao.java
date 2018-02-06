package persistence.dao;

import java.util.List;

import model.Ricetta;
import model.Utente;
import persistence.dao.jdbc.UtenteCredenziali;

public interface UtenteDao {
	
	public void save(Utente utente, String password);
	
	public Utente findByPrimaryKey(String username);
	
	public List<Utente> findAll();       
	
	public void update(Utente utente); 
	
	public void delete(Utente utente); 
	
	public Utente findByEmail(String email);
	
	public UtenteCredenziali findByPrimaryKeyCredential(String username);
	
	public void setPassword(Utente utente, String password);
	
	public void insertRicettaPreferita(Ricetta ricetta,Utente utente);
	
}
