package persistence.dao;

import java.util.List;

import model.Categoria;
import model.Ricetta;
import model.Utente;

public interface RicettaDao {
	
	public void save(Ricetta ricetta);
	
	public Ricetta findByPrimaryKey(Long id);
	
	public List<Ricetta> findAll();       
	
	public void update(Ricetta ricetta);
	
	public void delete(Ricetta ricetta); 
	
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	
	public List<Ricetta> findByTitolo(String titolo); /* substring del titolo */
	
	public List<Ricetta> findByCategoria(Categoria categoria);
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	
	public List<Ricetta> findByUtente(Utente utente);
	
	public List<Ricetta> findRicettePubblicateByUtente(Utente utente);

	
}
