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

    @Override
    public void saveOrUpdate(String baseCharCode, String quotedCharCode) {
        session.beginTransaction();
        session.saveOrUpdate(new CurrencyPair(baseCharCode, quotedCharCode));
        session.getTransaction().commit();
    }

    @Override
    public CurrencyPair findByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        return session.createQuery("select cp from CurrencyPair as cp " +
                        "where baseCharCode = :baseCharCodeParam and quotedCharCode = :quotedCharCodeParam", CurrencyPair.class)
                .setParameter("baseCharCodeParam", baseCharCode)
                .setParameter("quotedCharCodeParam", quotedCharCode)
                .getSingleResult();
    }

    @Override
    public Integer getIdByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        return findByBaseCharAndQuotedChar(baseCharCode, quotedCharCode).getId();
    }
}
