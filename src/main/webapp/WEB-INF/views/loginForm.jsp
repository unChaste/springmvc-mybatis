<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h3>登陆页面</h3>
<form action="/login" method="post">
    <p style="color: red">${message}</p>
    <table>
        <tr>
            <td>
                <label>登陆名：</label>
            </td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>密码：</label>
            </td>
            <td>
                <input type="text" name="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登陆"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
