<!DOCTYPE html>
<html>
<head>
    <title>Add Product Form</title>
    <%--<style type="text/css">@import url("../../css/main.css");</style>--%>
</head>
<body>
<div id="global">
    <form action="/save-product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input type="reset" id="reset" value="reset" tabindex="4"/>
                <input type="submit" id="submit" value="Add Product" tabindex="5"/>
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>