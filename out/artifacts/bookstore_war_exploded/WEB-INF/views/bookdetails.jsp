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
    <title>О книге</title>
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
        <h3>[${book.article}]: ${book.author} - ${book.name}</h3>
        <b>Название:</b> ${book.name} <br>
        <b>Автор:</b> ${book.author} <br>
        <b>Описание:</b> ${book.description} <br>
        <b>Количество:</b> ${book.amountInStore} шт.<br>
        <b>Цена:</b> ${book.price} руб.<br>
        <form method="post" action="${pageContext.request.contextPath}/buyBook/?code=${book.article}">
            <input type="submit" value="Купить">
        </form>
        <form action="<c:url value="/booklist" /> ">
            <input type="submit" value="Назад" />
        </form>
    </div>
</body>
</html>
