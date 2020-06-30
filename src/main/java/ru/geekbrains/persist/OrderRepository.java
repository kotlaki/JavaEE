package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class OrderRepository {
    private Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds") // смотрим в название юнита в persistence.xml
    private EntityManager em;

    @TransactionAttribute
    public void insert(Orders orders) {
        em.persist(orders);
    }

    @TransactionAttribute
    public void update(Orders orders) {
        em.persist(orders);
    }

    @TransactionAttribute
    public void delete(long id) throws SQLException {
        Orders orders = em.find(Orders.class, id);
        if (orders != null) {
            em.remove(orders);
        }
    }

    @TransactionAttribute
    public Orders findById(long id) {
        return em.find(Orders.class, id);
    }

    @TransactionAttribute
    public List<Orders> findAll() {
        return em.createQuery("from Orders ", Orders.class).getResultList();
    }
}
