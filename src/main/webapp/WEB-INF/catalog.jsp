<%--
  Created by IntelliJ IDEA.
  User: voland
  Date: 31.03.2020
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Интернет магазин - Каталог товаров</title>
</head>
<body>
<h2>Каталог товаров</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${products}" var = "prod">
            <td>${prod.id}</td>
            <c:url value="catalog/product" var="prodUrl"/>
            <td>  <a href="${prodUrl}">${prod.name}</a><br></td>
            <td>${prod.description}</td>
        </tr>
    </c:forEach>
</table>
<%--<a href="./catalog/product">Товар</a><br>--%>
</body>
</html>
