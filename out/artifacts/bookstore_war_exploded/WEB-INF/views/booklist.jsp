<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mishima
  Date: 15.01.2019
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <div align="center">
        <h3>Available our books!</h3>
        <table>
            <thead>
            <tr>
                <th>Article</th>
                <th>Name</th>
                <th>Author</th>
                <th>Genre</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.article}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.price} USD</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
