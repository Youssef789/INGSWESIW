package persistence.dao;

import java.util.List;

import model.Commento;

public interface CommentoDao {
	
	public void save(Commento commento);  
	
	public Commento findByPrimaryKey(Long id);
	
	public List<Commento> findAll();       
	
	public void update(Commento commento); 
	
	public void delete(Commento commento);	

}
