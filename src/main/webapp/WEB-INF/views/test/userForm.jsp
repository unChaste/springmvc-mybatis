<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/2/8
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a User</title>
</head>
<body>
<form action="/test/saveUser" method="post">
    <p>
        <label>用户名：</label>
        <input type="text" name="name"/>
    </p>
    <p>
        <label>性别:</label>
        <input type="radio" name="gender" value="1"/>男&nbsp;&nbsp;
        <input type="radio" name="gender" value="2"/>女
    </p>
    <p>
        <label>身高(cm):</label>
        <input type="text" name="height"/>
    </p>
    <p>
        <label>出生日期:</label>
        <input type="text" name="birthday"/>
    </p>
    <p>
        <input type="submit" value="提交"/>
    </p>
</form>
</body>
</html>
