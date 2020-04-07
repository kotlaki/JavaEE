<%@ page import="ru.kurganov.Products" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: voland
  Date: 31.03.2020
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>

<head>
    <title>Интернет магазин - Каталог товаров</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Каталог товаров</h2>
<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/create" var="productCreateUrl"/>
            <a class="btn btn-primary" href="${productCreateUrl}">Добавить продукцию</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">ИД</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Действие</th>
                </tr>
                </thead>
            <tbody>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
<%--                    выводим поля товара из коллекции--%>
                    <th scope="row"><c:out value="${product.id}"/></th>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td>
                        <c:url value="/edit" var="productEditUrl">
                        <c:param name="id" value="${product.id}"/>
                        </c:url>
                        <a class="btn btn-success" href="${productEditUrl}"><i class="fas fa-edit"></i></a>
                        <c:url value="/delete" var="productDeleteUrl">
                            <c:param name="id" value="${product.id}"/>
                        </c:url>
                        <a class="btn btn-danger" href="${productDeleteUrl}"><i class="far fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
        </div>
    </div>
</div>
<%--<h2>Каталог товаров</h2>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Description</th>--%>
<%--    </tr>--%>
<%--&lt;%&ndash;    перебераем List и выводим его содержание&ndash;%&gt;--%>
<%--    <c:forEach items="${products}" var = "prod">--%>
<%--            <td>${prod.id}</td>--%>
<%--&lt;%&ndash;        делаем ссылку с передачей параметра name&ndash;%&gt;--%>
<%--            <c:url value="catalog/product?name=${prod.name}&desc=${prod.description}" var="prodUrl"/>--%>
<%--            <td>  <a href="${prodUrl}">${prod.name}</a><br></td>--%>
<%--            <td>${prod.description}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>
