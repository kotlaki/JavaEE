<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
<title>Интернет магазин - Главная страница</title>

<jsp:include page="WEB-INF/head.jsp">
    <jsp:param name="pageHeader" value="Интернет магазин - Главная страница"/>
</jsp:include>

<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h2>Главная страница</h2>

<ul class="list-group">
    <li class="list-group-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Главная</a>
    </li>
    <li class="list-group-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/catalog">Каталог товаров</a>
    </li>
    <li class="list-group-item">
        <a class="nav-link" href="#">Корзина</a>
    </li>
    <li class="list-group-item">
        <a class="nav-link" href="#">Оформление заказа</a>
    </li>
    <li class="list-group-item">
        <a class="nav-link" href="#">О компании</a>
    </li>
</ul>

</body>
</html>
