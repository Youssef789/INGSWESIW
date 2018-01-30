package persistence.dao;

import java.util.List;
import model.Utente;
import persistence.dao.jdbc.UtenteCredenziali;

public interface UtenteDao {
	
	public void save(Utente utente, String password);
	
	public Utente findByPrimaryKey(String username);
	
	public List<Utente> findAll();       
	
	public void update(Utente utente); 
	
	public void delete(Utente utente); 
	
	public UtenteCredenziali findByPrimaryKeyCredential(String username);
	
	public void setPassword(Utente utente, String password);

}
