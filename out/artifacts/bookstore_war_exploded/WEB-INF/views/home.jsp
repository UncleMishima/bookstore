<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mikhail Sedov
  Date: 15.01.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <h3>
                Welcome, ${userModel.fullName} | <a href="<c:url value="/logout"/>">Logout</a>
                <br> Let's shop a bit :)
            </h3>
        </c:when>
        <c:otherwise>
            <h3>Hello, stranger! <br> Authorize and look at our <a href="<c:url value="/booklist" />">books</a>! </h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
