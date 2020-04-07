<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: voland
  Date: 31.03.2020
  Time: 19:35
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
    <title>Интернет магазин - Товар</title>
</head>
<body>
<jsp:include page="./header.jsp"/>
<%--принимаем из линка параметры для дальнейшего использования--%>
<%String name = request.getParameter("name");%>
<%String desc = request.getParameter("desc");%>
<h2>Товар <%=name%></h2>
<h3><%=desc%></h3>
</body>
</html>
