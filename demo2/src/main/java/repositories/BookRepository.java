package repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.BookEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class BookRepository {
    @PersistenceContext
    private EntityManager em;

    public List<BookEntity> findAll() {
        return em.createQuery("select i from BookEntity i", BookEntity.class).getResultList();
    }

    public void persist(BookEntity entity) {
        em.persist(entity);
    }

    public void delete(int BookId) {
        BookEntity entity = em.find(BookEntity.class, BookId);
        em.remove(entity);
    }
}
