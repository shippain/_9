<%--
  Created by IntelliJ IDEA.
  User: Ping
  Date: 02.06.2019
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/update" method="post">
    <label for="product_name">Product name</label>
    <input type="text" name="product_name" id="product_name" value="${product.name}">

    <label for="product_price">Product price</label>
    <input type="number" name="product_price" id="product_price" value="${product.price}">

    <input type="hidden" name="product_id" id="product_id" value="${product.id}">

    <input type="submit">
</form>

</body>
</html>
