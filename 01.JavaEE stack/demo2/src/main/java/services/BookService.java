package services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import models.BookEntity;
import models.dto.BookRequest;
import repositories.BookRepository;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class BookService {
    @Inject
    private BookRepository BookRepository;

    public List<BookEntity> getAll() {
        return BookRepository.findAll();
    }

    public int create(BookRequest BookRequest) {
        BookEntity Book = new BookEntity(1, BookRequest.getTittle(), BookRequest.getAuthor_id(), BookRequest.getPublic_year());
        BookRepository.persist(Book);
        return Book.getId();
    }

    public void delete(int gameId) {
        BookRepository.delete(gameId);
    }
}
