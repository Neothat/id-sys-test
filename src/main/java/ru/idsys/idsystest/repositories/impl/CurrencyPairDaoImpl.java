package ru.idsys.idsystest.repositories.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.utils.HibernateUtil;

import java.util.List;

@Repository
public class CurrencyPairDaoImpl implements CurrencyPairDao {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<CurrencyPair> getAllCurrencyPair() {
        return session.createQuery("from CurrencyPair", CurrencyPair.class).getResultList();
    }

    @Override
    public CurrencyPair findById(Integer id) {
        return session.get(CurrencyPair.class, id);
    }
}
