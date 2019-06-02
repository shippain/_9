<%--
  Created by IntelliJ IDEA.
  User: Ping
  Date: 02.06.2019
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>


<table>
    <caption>Products</caption>
    <tr>
        <th>Product</th>
        <th>Price</th>
    </tr>

    <c:forEach items="${productList}" var="prg">
        <tr>
            <td><c:out value="${prg.name}"> </c:out></td>
            <td><c:out value="${prg.price}"> </c:out></td>
            <td>
                <form action="product/update" method="get">
                    <input type="hidden" value="${prg.id}" name="product_id">
                    <input type="submit" value="edit">
                </form>
            </td>
            <td>
                <form action="product/remove" method="post">
                    <input type="hidden" value="${prg.id}" name="product_id">
                    <input type="submit" value="remove">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<button><a href="/add_product.jsp">Add</a></button>
</body>
</html>
