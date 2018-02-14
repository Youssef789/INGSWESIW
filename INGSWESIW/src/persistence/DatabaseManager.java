package persistence;

public class DatabaseManager {

	private static DatabaseManager instance = null;

	private DAOFactory daoFactory;

	private DatabaseManager() {
		daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	}

	public static DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	public DAOFactory getDaoFactory() {
		return daoFactory;
	}
	
}
