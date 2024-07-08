package jm.task.core.jdbc.util;

import org.hibernate.Session;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Alishka12345";
    private final static Logger LOGGER = Logger.getLogger(Util.class.getName());

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().addAnnotatedClass(User.class);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
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
