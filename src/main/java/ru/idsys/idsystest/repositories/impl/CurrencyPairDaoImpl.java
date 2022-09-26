package ru.idsys.idsystest.repositories.impl;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.utils.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
@Slf4j
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
        if (findByBaseCharAndQuotedChar(baseCharCode, quotedCharCode) == null) {
            session.saveOrUpdate(new CurrencyPair(baseCharCode, quotedCharCode));
        }
        session.getTransaction().commit();
    }

    @Override
    public CurrencyPair findByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        CurrencyPair currencyPair = null;
        try {
            currencyPair = session.createQuery("select cp from CurrencyPair as cp " +
                            "where baseCharCode = :baseCharCodeParam and quotedCharCode = :quotedCharCodeParam", CurrencyPair.class)
                    .setParameter("baseCharCodeParam", baseCharCode)
                    .setParameter("quotedCharCodeParam", quotedCharCode)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.warn(String.format("Entity with baseCharCode: %s and quotedCharCode: %s not found", baseCharCode, quotedCharCode));
        }
        return currencyPair;
    }
}
