<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mikhail Sedov
  Date: 22.01.2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book details</title>
</head>
<body>
    <div align="center">
        <h3>[${book.article}]: ${book.author} - ${book.name} details</h3>
        <b>Name:</b> ${book.name} <br>
        <b>Author:</b> ${book.author} <br>
        <b>Description:</b> ${book.description} <br>
        <b>Price:</b> ${book.price} руб.<br>
        <form action="<c:url value="" /> ">
            <input type="submit" value="Добавить в корзину" />
        </form>
        <form action="<c:url value="/booklist" /> ">
            <input type="submit" value="Назад" />
        </form>
    </div>
</body>
</html>
