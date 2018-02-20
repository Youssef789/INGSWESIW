package persistence.dao;

import java.util.List;

import model.Ricetta;
import model.Utente;
import persistence.dao.jdbc.UtenteCredenziali;

public interface UtenteDao {
	
public void save(Utente utente, String password);
	
	public void update(Utente utente); 
	
	public void delete(Utente utente); 
	
	public List<Utente> findAll();       
	
	public Utente findByPrimaryKey(String username);
	
	public Utente findByEmail(String email);
	
	public UtenteCredenziali findByPrimaryKeyCredential(String username);
	
	public void setPassword(Utente utente, String password);
	
	public Ricetta findRicettaPreferita(Utente utente, Ricetta ricetta);
	
	public void insertRicettaPreferita(Utente utente, Ricetta ricetta);
	
	public void deleteRicettaPreferita(Utente utente, Ricetta ricetta);
	
	public void insertFollowing(Utente utente, Utente following);
	
	public void deleteFollowing(Utente utente, Utente following);
	
	public Utente findFollower(Utente utente, Utente follower);
	
	public void insertFollower(Utente utente, Utente follower);
	
	public void deleteFollower(Utente utente, Utente follower);
	
}
