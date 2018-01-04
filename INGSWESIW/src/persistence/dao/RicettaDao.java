package persistence.dao;

import java.util.List;

import model.Ricetta;

public interface RicettaDao {
	
	public void save(Ricetta ricetta);  // Create
	public Ricetta findByPrimaryKey(Long id);     // Retrieve
	public List<Ricetta> findByCategory(String Type);
	public List<Ricetta> findAll();       
	public void update(Ricetta ricetta); //Update
	public void delete(Ricetta ricetta); //Delete	

}
