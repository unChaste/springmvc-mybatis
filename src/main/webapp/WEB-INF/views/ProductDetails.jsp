<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Save Product</title>
    <%--<style type="text/css">@import url("../../css/main.css");</style>--%>
</head>
<body>
<div id="global">
    <h4>${message}</h4>
    <p>
    <h5>Details: </h5>
    Product Name: ${product.name}<br/>
    Description: ${product.description}<br/>
    Price: ${product.price}
    </p>
    <a href="/list-product">返回列表</a>
</div>
</body>
</html>