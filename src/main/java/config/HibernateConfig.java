package config;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory = buildSessonFactory();
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static SessionFactory buildSessonFactory(){
        try {

            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

        }catch(ExceptionInInitializerError eiie){

            System.out.println(eiie.getLocalizedMessage());
            throw new ExceptionInInitializerError();

        }
    }

}
