<%--
  Created by IntelliJ IDEA.
  User: Ping
  Date: 02.06.2019
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
    <form action="product/add" method="post">
        <label for="product_name">Product name</label>
        <input type="text" name="product_name" id="product_name">

        <label for="product_price">Product price</label>
        <input type="number" name="product_price" id="product_price">

        <input type="submit">
    </form>
</body>
</html>
