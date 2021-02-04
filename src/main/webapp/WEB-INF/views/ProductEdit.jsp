<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Product Edit</title>
</head>
<body>
<form action="/update-product" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <fieldset>
        <legend>Edit a product</legend>
        <p>
            <label for="name">Product Name:</label>
            <input type="text" id="name" name="name" value="${product.name}" tabindex="1">
        </p>
        <p>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value="${product.description}" tabindex="2">
        </p>
        <p>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${product.price}" tabindex="3">
        </p>
        <p id="buttons">
            <input type="reset" id="reset" value="reset" tabindex="4"/>
            <input type="submit" id="submit" value="Add Product" tabindex="5"/>
        </p>
    </fieldset>
</form>
</body>
</html>
