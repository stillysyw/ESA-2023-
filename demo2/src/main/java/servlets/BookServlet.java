package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.BookEntity;
import models.dto.BookRequest;
import services.BookService;
import utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "gameServlet", value = "/books")
public class BookServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private BookService BookService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
                List<BookEntity> Book = BookService.getAll();
                request.setAttribute("bookList", Book);

        try {
            getServletContext().getRequestDispatcher("/book.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            BookRequest gameRequest = objectMapper.readValue(is, BookRequest.class);
            BookService.create(gameRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int gameId = 1;
        BookService.delete(gameId);
    }
}
