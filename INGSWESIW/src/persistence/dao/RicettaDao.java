package persistence.dao;

import java.util.List;

import model.Ricetta;

public interface RicettaDao {
	
	public void save(Ricetta ricetta);
	
	public Ricetta findByPrimaryKey(Long id);
	
	public List<Ricetta> findAll();       
	
	public void update(Ricetta ricetta);
	
	public void delete(Ricetta ricetta); 
	
	////////////////////////////////////
	////////////////////////////////////
	////////////////////////////////////
	
	public List<Ricetta> findByTitolo(String titolo); /* substring del titolo */
	
}
