package matutu.giosan777.ge.factory;

import matutu.giosan777.ge.DAO.Impl.UserDaoImpl;
import matutu.giosan777.ge.DAO.UserDAO;

// giosan777 ...
public class FactoryDAO {
    private static FactoryDAO ourInstance = null;
    private static UserDAO userDAO = null;

    public static synchronized FactoryDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new FactoryDAO();
        }
        return ourInstance;
    }

    private FactoryDAO() {
    }

    public UserDAO getUserDao() {
        if (userDAO == null) {
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }
}
