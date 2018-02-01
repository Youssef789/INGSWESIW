package persistence;

import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;
import persistence.dao.jdbc.CommentoDaoJDBC;
import persistence.dao.jdbc.RicettaDaoJDBC;
import persistence.dao.jdbc.UtenteDaoJDBC;
import persistence.dao.jdbc.VotoDaoJDBC;

public class PostgresDAOFactory extends DAOFactory {
	
	private static DataSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			// Questi dati vanno messi nel file di configurazione!	
			// (es.) dataSource = new DataSource("jdbc:postgresql://52.39.164.176:5432/xxx", "xxx", "p@xxx");
			dataSource = new DataSource("jdbc:postgresql://localhost:5433/SoRecipes", "postgres", "postgres");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	
	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
	}
	
	/////////////////////////////////
	/////////////////////////////////
	/////////////////////////////////
	
	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}
	
	@Override
	public RicettaDao getRicettaDAO() {
		return new RicettaDaoJDBC(dataSource);
	}
	
	@Override
	public CommentoDao getCommentoDAO() {
		return new CommentoDaoJDBC(dataSource);
	}

	@Override
	public VotoDao getVotoDAO() {
		return new VotoDaoJDBC(dataSource);
	}

}
