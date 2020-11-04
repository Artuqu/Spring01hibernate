<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-10-11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
Books:
<table border="1">
    <tr>
        <th>Lp.</th>
        <th>Title</th>
        <th>Description</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Pages</th>
        <th>Author</th>
        <th>Action</th>

    </tr>

        <c:forEach items="${books}" var="book" varStatus="stat">
    <tr>
        <td>${stat.count}</td>
        <td>${book.title}</td>
        <td>${book.description}</td>
        <td>${book.rating}</td>
        <td>${book.publisher.name}</td>
        <td>${book.pages}</td>
        <td>${book.author.name}</td>
        <td>
            <form:form method="post" modelAttribute="book">
                <label for="action"></label>
        </form:form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>



