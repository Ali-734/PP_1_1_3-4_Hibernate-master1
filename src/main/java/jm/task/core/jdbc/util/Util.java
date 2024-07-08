package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.logging.Logger;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Alishka12345";
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().addAnnotatedClass(User.class);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USERNAME);
            configuration.setProperty("hibernate.connection.password", PASSWORD);
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            sessionFactory = configuration.buildSessionFactory();
            LOGGER.info("SessionFactory created");
        } catch (Exception e) {
            LOGGER.severe("Error creating SessionFactory: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
