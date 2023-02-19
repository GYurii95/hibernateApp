package ru.gyurii.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gyurii.springcourse.model.Actor;
import ru.gyurii.springcourse.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(.class)
                .addAnnotatedClass(.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try(sessionFactory) {
            session.beginTransaction();


            session.getTransaction().commit();
        }
    }
}
