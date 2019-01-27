<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mikhail Sedov
  Date: 25.01.19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <div align="center">
        <h3>Cart</h3>
        <c:choose>
            <c:when test="${not empty cartLines}">
                <table>
                    <thead>
                    <tr>
                        <th>Book</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartLines}" var="cartLine">
                        <tr>
                            <td>${cartLine.book}</td>
                            <td>${cartLine.buyingPrice}</td>
                            <td>${cartLine.bookCount}</td>
                            <td>${cartLine.total} руб.</td>
                            <td><a href="<c:url value="/booklist/bookdetails/${book.article}"/>">Купить</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="jumbotron">
                    <div class="text-center">
                        <h2>Cart is empty</h2>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
