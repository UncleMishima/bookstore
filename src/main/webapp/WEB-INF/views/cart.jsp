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
        <c:choose>
            <c:when test="${not empty cartLines}">
                <h3>Корзина</h3>
                <table>
                    <thead>
                    <tr>
                        <th>Книга</th>
                        <th>Кол-во (шт.)</th>
                        <th>Цена</th>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${cartLines}" var="cartLine">
                        <tr>
                            <td>${cartLine.book.author} - ${cartLine.book.name}</td>
                            <td>${cartLine.bookCount}</td>
                            <td>${cartLine.total} руб.</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <b>Total price: </b> ${cart.totalPrice}
            </c:when>
            <c:otherwise>
                <div>
                    <h2>В корзине нет товаров</h2>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/orderBooks/?code=${userModel.cart.id}">
        <input type="submit" value="Заказать">
    </form>
    <form action="<c:url value="/booklist"/> ">
        <input type="submit" value="Назад">
    </form>

</body>
</html>
