<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: voland
  Date: 31.03.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Интернет магазин - Товар</title>
</head>
<body>
<%--принимаем из линка параметры для дальнейшего использования--%>
<%String name = request.getParameter("name");%>
<%String desc = request.getParameter("desc");%>
<h2>Товар <%=name%></h2>
<h3><%=desc%></h3>
</body>
</html>
