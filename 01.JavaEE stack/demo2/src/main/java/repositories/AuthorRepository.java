package repositories;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.AuthorEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    public List<AuthorEntity> findAll() {
        em.createQuery("select i from AuthorEntity i", AuthorEntity.class);
        return em.createQuery("select i from AuthorEntity i", AuthorEntity.class).getResultList();
    }

    public void persist(AuthorEntity entity) {
        em.persist(entity);
    }

    public void delete(int AuthorId) {
        AuthorEntity entity = em.find(AuthorEntity.class, AuthorId);
        em.remove(entity);
    }
}
