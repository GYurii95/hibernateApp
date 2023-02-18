package ru.gyurii.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gyurii.springcourse.model.Passport;
import ru.gyurii.springcourse.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("User1", 30);
            Passport passport = new Passport(123);

            person.setPassport(passport);

            session.save(person);

            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }
    }
}
