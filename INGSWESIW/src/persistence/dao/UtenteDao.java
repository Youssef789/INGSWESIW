package persistence.dao;

import java.util.List;
import model.Utente;
import persistence.UtenteCredenziali;

public interface UtenteDao {
	public void save(Utente utente); // Create
	public Utente findByPrimaryKey(long id); // Retrieve
	public Utente findByPrimaryKeyJoinRecipe(Long id);
	public Utente findByPrimaryKeyJoinComment(Long id);
	public Utente findByPrimaryKeyJoinVote(Long id);
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	public boolean checkLogin(String email,String password);
	public void setFollower(Utente utente,Utente utente2);
	public void setFollowing(Utente utente,Utente utente2);
	public void setPassword(Utente utente, String password);
	public UtenteCredenziali findByPrimaryKeyCredential(Long id); 
}
