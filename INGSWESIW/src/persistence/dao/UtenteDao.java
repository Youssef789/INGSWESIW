package persistence.dao;

import java.util.List;
import model.Utente;
import persistence.dao.jdbc.UtenteConPassword;

public interface UtenteDao {
	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String email);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	public boolean checkLogin(String email,String password) ;
	public void setPassword(Utente utente, String password);
	public UtenteConPassword findByPrimaryKeyCredential(String email); 
}
