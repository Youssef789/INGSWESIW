package persistence.dao;

import java.util.Set;

import model.Commento;
import model.Ricetta;
import model.Utente;

public interface CommentoDao {
		
	public void save(Commento commento);  
	
	public void update(Commento commento); 
	
	public void delete(Commento commento);
	
	public Set<Commento> findAll(); 
	
	public Commento findByPrimaryKey(Long id);
	
	public Set<Commento> findByRicetta(Ricetta ricetta); /* su quale ricetta è stata pubblicato il commento */
	
	public Set<Commento> findByUtente(Utente utente); /* quale utente ha pubblicato il commento */

}
