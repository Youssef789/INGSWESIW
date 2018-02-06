package persistence.dao;

import java.util.List;

import model.Categoria;
import model.Ricetta;
import model.Utente;

public interface RicettaDao {
	
	public void saveAsBozza(Ricetta ricetta);

	public void saveAsPubblicata(Ricetta ricetta);
		
	public Ricetta findByPrimaryKey(Long id);
	
	public List<Ricetta> findAllPubblicate();

	public List<Ricetta> findAllBozzeByUtente(Utente utente);
	
	public List<Ricetta> findAllPubblicateByUtente(Utente utente);
	
	public List<Ricetta> findAllPubblicateByCategoria(Categoria categoria);
	
	public List<Ricetta> findAllPubblicateByTitolo(String titolo);
	
	public void updateAsBozza(Ricetta ricetta);
	
	public void updateAsPubblicata(Ricetta ricetta);
	
	public void delete(Ricetta ricetta);
	
	

}
