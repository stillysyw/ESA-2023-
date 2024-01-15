package services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import models.AuthorEntity;
import models.dto.AuthorRequest;
import repositories.AuthorRepository;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class AuthorService {
    @Inject
    private AuthorRepository AuthorRepository;


    public List<AuthorEntity> getAll() {
        return AuthorRepository.findAll();
    }

    public int create(AuthorRequest AuthorRequest) {
        AuthorEntity Author = new AuthorEntity(1, AuthorRequest.getName());
        AuthorRepository.persist(Author);
        return Author.getId();
    }

    public void delete(int developertId) {
        AuthorRepository.delete(developertId);
    }
}
