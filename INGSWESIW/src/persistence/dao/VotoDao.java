package persistence.dao;

import java.util.List;

import model.Voto;

public interface VotoDao {
	
	public void save(Voto voto);
	
	public List<Voto> findAll();
	
	public Voto findByPrimaryKey(Long id);
	
	public void update(Voto voto);
	
	public void delete(Voto voto);	

}
