<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/2/5
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<head>
    <title>View Product</title>
    <script src="https://lib.baomitu.com/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<p>
    <input type="text" id="productId" name="id"/>
    <input type="button" id="viewProduct" value="查看"/>
</p>
<p>
    Name: <span id="name"></span><br/>
    Description: <span id="description"></span><br/>
    Price: <span id="price"></span>
</p>

<script>
    $('#viewProduct').on('click', function () {
        var productId = $("#productId").val();
        var data = {
            id: productId,
            name: "ssm"
        };
        $.ajax('/select-product', {
            dataType: "json",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(data),
            async: true,
            success: function (data) {
                console.log(data);
                $("#name").html(data.name);
                $("#description").html(data.description);
                $("#price").html(data.price);
            },
            error: function () {
                console.log("数据发送失败");
            }
        });
    });
</script>
</body>
</html>
