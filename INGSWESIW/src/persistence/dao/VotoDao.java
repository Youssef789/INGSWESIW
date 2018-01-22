package persistence.dao;

import java.util.List;

import model.Voto;
public interface VotoDao {
	
	public void save(Voto voto);  // Create
	public Voto findByPrimaryKey(Long id);     // Retrieve
	
	public List<Voto> findAll();       
	public void update(Voto voto); //Update
	public void delete(Voto voto); //Delete	

}
