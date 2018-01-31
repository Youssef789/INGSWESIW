package persistence;

import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;

public class PostgresDAOFactory extends DAOFactory {
	
	private static  DataSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
			//dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/SoRecipe","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	@Override
	public RicettaDao getRicrttaDAO() {
		return new RicettaDaoJDBC(dataSource);
	}
	
	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
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
