package persistence.dao;

import java.util.Set;

import model.Ricetta;
import model.Utente;
import model.Voto;

public interface VotoDao {
	
	public void save(Voto voto);
	
	public void update(Voto voto);
	
	public void delete(Voto voto);
	
	public Set<Voto> findAll();
	
	public Voto findByPrimaryKey(Long id);
	
	public Set<Voto> findByRicetta(Ricetta ricetta); /* su quale ricetta è stata effettuata la votazione */

	public Set<Voto> findByUtente(Utente utente); /* quale utente ha effettuato la votazione */
	
	public Voto findByRicettaAndUtente(Ricetta ricetta, Utente utente); /* il voto effettuato su una specifica ricetta da uno specifico utente */
	
}
