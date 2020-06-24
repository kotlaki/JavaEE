package ru.geekbrains.persist;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {
    private Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @Inject
    private UserTransaction ut;

    @PersistenceContext(unitName = "ds") // смотрим в название юнита в persistence.xml
    private EntityManager em;

    @Transactional
    public void insert(Orders orders) {
        em.persist(orders);
    }

    @Transactional
    public void update(Orders orders) {
        em.persist(orders);
    }

    @Transactional
    public void delete(long id) throws SQLException {
        Orders orders = em.find(Orders.class, id);
        if (orders != null) {
            em.remove(orders);
        }
    }

    @Transactional
    public Orders findById(long id) {
        return em.find(Orders.class, id);
    }

    @Transactional
    public List<Orders> findAll() {
        return em.createQuery("from Orders ", Orders.class).getResultList();
    }
}
