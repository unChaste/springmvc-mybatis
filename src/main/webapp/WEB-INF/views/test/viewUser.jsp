<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/2/8
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查看用户</title>
</head>
<body>
<p>
    用户名：${user.name}
</p>
<p>
    性别：
    <c:choose>
        <c:when test="${user.gender == 1}">
            男
        </c:when>
        <c:when test="${user.gender == 2}">
            女
        </c:when>
        <c:otherwise>
            未知
        </c:otherwise>
    </c:choose>
</p>
<p>
    身高(cm)：${user.height}
</p>
<p>
    出生日期：<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
</p>
</body>
</html>
