package ru.idsys.idsystest.repositories.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.entyties.ExchangeRate;
import ru.idsys.idsystest.repositories.ExchangeRateDao;
import ru.idsys.idsystest.utils.HibernateUtil;

@Repository
public class ExchangeRateDaoImpl implements ExchangeRateDao {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public ExchangeRate getExchangeRate(CurrencyPair currencyPair) {
        return session.createQuery("select er from ExchangeRate as er where currencyPair = :currencyPairParam order by rateDate desc", ExchangeRate.class)
                .setParameter("currencyPairParam", currencyPair)
                .setMaxResults(1)
                .getSingleResult();
    }
}