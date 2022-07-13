package com.rns.test.hibernate;

import com.rns.test.entity.Tires;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateAdd {

    SessionFactory sessionFactory= new HibernateConnect().getFactory();


    public void addToDB ( List<Tires> tiresList) {

        for (Tires tire: tiresList) {
            addCurrent(tire);
        }
    }


    private void addCurrent(Tires tire) {

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(tire);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
