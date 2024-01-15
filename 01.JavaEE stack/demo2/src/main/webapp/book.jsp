<%@ page import="java.util.List" %>
<%@ page import="models.BookEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Books</title>
</head>
<body>
<h1><%= "Books page:" %></h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author id</th>
        <th>Public year</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<BookEntity> booksList = (List<BookEntity>)request.getAttribute("booksList");
        for (BookEntity book : booksList) {
    %>
    <tr>
        <td><%= book.getId() %></td>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor_id() %></td>
        <td><%= book.getPublic_year() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>