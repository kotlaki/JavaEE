package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class CategoryRepository {

    private Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds") // смотрим в название юнита в persistence.xml
    private EntityManager em;

    @TransactionAttribute
    public void insert(Category category) {
        em.persist(category);
    }

    @TransactionAttribute
    public void update(Category category) {
        em.persist(category);
    }

    @TransactionAttribute
    public void delete(long id) throws SQLException {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    @TransactionAttribute
    public Category findById(long id) {
        return em.find(Category.class, id);
    }

    @TransactionAttribute
    public List<Category> findAll() {
        return em.createQuery("from Category ", Category.class).getResultList();
    }

}
