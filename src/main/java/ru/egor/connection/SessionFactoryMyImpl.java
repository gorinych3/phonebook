package ru.egor.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMyImpl {
    private static SessionFactory sessionFactory;

    public static SessionFactory getInstance() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

    private SessionFactoryMyImpl(){

    }
}
