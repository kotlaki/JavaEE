package ru.geekbrains.persist;

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
public class CategoryRepository {

    private Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @Inject
    private UserTransaction ut;

    @PersistenceContext(unitName = "ds") // смотрим в название юнита в persistence.xml
    private EntityManager em;

    @Transactional
    public void insert(Category category) {
        em.persist(category);
    }

    @Transactional
    public void update(Category category) {
        em.persist(category);
    }

    @Transactional
    public void delete(long id) throws SQLException {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    @Transactional
    public Category findById(long id) {
        return em.find(Category.class, id);
    }

    @Transactional
    public List<Category> findAll() {
        return em.createQuery("from Category ", Category.class).getResultList();
    }

}
