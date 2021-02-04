<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/2/3
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<form action="/list-product" method="get">
    <p>
        <span>
        <input type="text" name="name"/>
        <input type="submit" value="搜索"/>
        </span>
        <span>
            <a href="/input-product">添加</a>
        </span>
    </p>
</form>
<table border="1">
    <tr>
        <th>书名</th>
        <th>描述</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <c:forEach var="product" items="${pageInfo.list}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <a href="/view-product?productId=${product.id}">详情</a>&nbsp;
                <a href="/edit-product?productId=${product.id}">修改</a>&nbsp;
                <a href="/delete-product?productId=${product.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
