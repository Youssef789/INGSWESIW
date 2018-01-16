package persistence.dao.jdbc;

import java.util.List;

import model.Utente;
import model.Voto;
import persistence.DataSource;
import persistence.dao.VotoDao;

public class VotoDaoJDBC implements VotoDao {

	public VotoDaoJDBC(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Voto voto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utente findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto voto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Voto voto) {
		// TODO Auto-generated method stub

	}

}
