package persistence.dao;

import java.util.List;

import model.Ricetta;
import model.Utente;
import model.Voto;

public interface VotoDao {
	
	public void save(Voto voto);
	
	public List<Voto> findAll();
	
	public Voto findByPrimaryKey(Long id);
	
	public void update(Voto voto);
	
	public void delete(Voto voto);
	
	public List<Voto> findByRicetta(Ricetta ricetta); /* su quale ricetta è stata effettuata la votazione */

	public List<Voto> findByUtente(Utente utente); /* quale utente ha effettuato la votazione */
	
}
