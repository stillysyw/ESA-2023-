<%@ page import="java.util.List" %>
<%@ page import="models.AuthorEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Authors</title>
</head>
<body>
<h1><%= "Authors page:" %></h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<AuthorEntity> AuthorList = (List<AuthorEntity>)request.getAttribute("booksList");
        for (AuthorEntity Author : AuthorList) {
    %>
    <tr>
        <td><%= Author.getId() %></td>
        <td><%= Author.getName() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>