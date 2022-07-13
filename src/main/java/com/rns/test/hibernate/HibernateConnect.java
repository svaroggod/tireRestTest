package com.rns.test.hibernate;

import com.rns.test.Config;
import com.rns.test.entity.TireSpecification;
import com.rns.test.entity.Tires;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnect implements Config {


    public SessionFactory getFactory() {

        return new Configuration()
                .setProperty("hibernate.connection.url", DB_CONN_URL)
                .setProperty("hibernate.connection.username", DB_CONN_USERNAME)
                .setProperty("hibernate.connection.password", DB_CONN_PASSWORD)
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Tires.class)
                .addAnnotatedClass(TireSpecification.class)
                .buildSessionFactory();
    }
}