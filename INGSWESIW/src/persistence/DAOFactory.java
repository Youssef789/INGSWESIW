package persistence;

import persistence.dao.CommentoDao;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;

public abstract class DAOFactory {
		
	// --- List of supported DAO types ---

	/**
	 * Numeric constant '1' corresponds to explicit Hsqldb choice
	 */

	public static final int HSQLDB = 1;

	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */

	public static final int POSTGRESQL = 2;
	
	/**
	 * Numeric constant '3' corresponds to explicit MariaDB choice
	 */
	
	public static final int MARIADB = 3;

	// --- Actual factory method ---

	/**
	 * Depending on the input parameter
	 * this method returns one out of several possible 
	 * implementations of this factory spec 
	 */

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case HSQLDB:
				return null; // new HsqldbDAOFactory();
			case MARIADB:
				return null; // new MariadbDAOFactory();
			case POSTGRESQL:
				return new PostgresDAOFactory();
			default:
				return null;
		}
	}

	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---

	public abstract UtilDao getUtilDAO();
	
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	
	public abstract CommentoDao getCommentoDAO();
	
	public abstract RicettaDao getRicettaDAO();
	
	public abstract UtenteDao getUtenteDAO();
	
	public abstract VotoDao getVotoDAO();

}
