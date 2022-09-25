package ru.idsys.idsystest.utils;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.entyties.ExchangeRate;

@Slf4j
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure()
                    .addAnnotatedClass(CurrencyPair.class)
                    .addAnnotatedClass(ExchangeRate.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            log.error("Initial SessionFactory creation failed. ", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}