package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.AuthorEntity;
import models.dto.AuthorRequest;
import services.AuthorService;
import utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "authorServlet", value = "/authors")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private AuthorService AuthorService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<AuthorEntity> author = AuthorService.getAll();
        request.setAttribute("authorList", author);

        try {
            getServletContext().getRequestDispatcher("/author.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            AuthorRequest developerRequest = objectMapper.readValue(is, AuthorRequest.class);
            AuthorService.create(developerRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int developerId = 1;
        AuthorService.delete(developerId);
    }
}
