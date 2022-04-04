package com.corso.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class EventTest {

    private SessionFactory sessionFactory;

    public static void main(String arg[]) throws Exception {
        EventTest test = new EventTest();
        test.setUp();
        test.testBasicUsage();
        test.shutDown();
    }

    protected void setUp() throws Exception {
        sessionFactory = new Configuration()
                .configure() // configura la SessionFactory utilizzando l' hibernate.cfg.xml
                .buildSessionFactory();
    }

    protected void shutDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public void testBasicUsage() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Event("Il nostro primo Evento!", "Il nostro primo evento che emozione!", new Date()));
        session.save(new Event("Un Evento seguente", "", new Date()));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Event> result = session.createQuery("from Event").list();
        for (Event event : (List<Event>) result) {
            System.out.println("Event (" + event.getDate() + ") : " + event.getTitle() + "  " + event.getDescription());
        }
        session.getTransaction().commit();
        session.close();
    }
}
