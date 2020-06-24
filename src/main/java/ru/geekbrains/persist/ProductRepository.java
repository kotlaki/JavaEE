package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    private Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @Inject
    private UserTransaction ut;

    @PersistenceContext(unitName = "ds") // смотрим в название юнита в persistence.xml
    private EntityManager em;

    @Transactional
    public void insert(Products product) {
       em.persist(product);
    }

    @Transactional
    public void update(Products product) {
        em.persist(product);
    }

    @Transactional
    public void delete(long id) throws SQLException {
        Products product = em.find(Products.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Products findById(long id) {
        return em.find(Products.class, id);
    }

    public List<Products> findAll() {

        return em.createQuery("from Products ", Products.class).getResultList();
    }
}