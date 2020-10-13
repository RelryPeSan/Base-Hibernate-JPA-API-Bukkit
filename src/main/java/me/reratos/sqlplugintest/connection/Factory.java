package me.reratos.sqlplugintest.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class Factory {
    static EntityManager em = null;
    static EntityManagerFactory emf = null;

    static {
        Thread.currentThread().setContextClassLoader(Factory.class.getClassLoader());
    }

    public static EntityManager getConnection() {
        if(em != null) return em;

        Properties properties = new Properties();

        properties.put("javax.persistence.jdbc.url",
                "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "password");

        emf = Persistence.createEntityManagerFactory("MySQL8Dialect", properties);
//        emf = Persistence.createEntityManagerFactory("MySQL8Dialect");
        em = emf.createEntityManager();

        return em;
    }
}
