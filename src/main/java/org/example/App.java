package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);

            System.out.println("Got person");

            session.getTransaction().commit();
            //session.close() - Hibernate call it automatically when we use commit()

            System.out.println("session closed");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("inside 2 transaction");

            List<Item> items = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
                    .setParameter("personId", person.getId()).getResultList();

            System.out.println(items);

            session.getTransaction().commit();

            System.out.println("outside 2 session");

        } finally {
            sessionFactory.close();
        }

    }
}
