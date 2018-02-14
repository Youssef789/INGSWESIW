package persistence.dao;

import java.util.Set;

import model.Categoria;
import model.Ricetta;
import model.Utente;

public interface RicettaDao {
	
	public void saveAsBozza(Ricetta ricetta);

	public void saveAsPubblicata(Ricetta ricetta);
	
	public void updateAsBozza(Ricetta ricetta);
	
	public void updateAsPubblicata(Ricetta ricetta);
	
	public void delete(Ricetta ricetta);
		
	public Ricetta findByPrimaryKey(Long id);
	
	public Set<Ricetta> findAllPubblicate();

	public Set<Ricetta> findAllBozzeByUtente(Utente utente);
	
	public Set<Ricetta> findAllPubblicateByUtente(Utente utente);
	
	public Set<Ricetta> findAllPubblicateByCategoria(Categoria categoria);
	
	public Set<Ricetta> findAllPubblicateByTitolo(String titolo);
	
}
