<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mikhail Sedov
  Date: 27.01.2019
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${bookGenre}</title>
</head>
<body>
    <div align="center">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h3>${userModel.fullName} | <a href="<c:url value="/logout" />" >Logout</a><br>
                <a href="<c:url value="/cart/show" />">Сумма заказа:</a> ${userModel.cart.totalPrice}
            </h3>
        </c:if>
    </div>
    <div align="center">
        <h3>Книги жанра ${bookGenre}</h3>
        <table>
            <thead>
                <tr>
                    <th>Артикль</th>
                    <th>Нзавание</th>
                    <th>Автор</th>
                    <th>Жанр</th>
                    <th>Цена</th>
                    <th></th>
                </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.article}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.price} руб.</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/buyBook/?code=${book.article}">
                            <input type="submit" value="Купить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="<c:url value="/booklist" /> ">
            <input type="submit" value="Назад" />
        </form>
    </div>
</body>
</html>
