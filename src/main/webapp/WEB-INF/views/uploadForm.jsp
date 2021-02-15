<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/2/10
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h2>文件上传</h2>
<p>
    ${message}
</p>
<form action="/upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>文件描述：</td>
            <td>
                <input type="text" name="description"/>
            </td>
        </tr>
        <tr>
            <td>请选择文件：</td>
            <td>
                <input type="file" name="file"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="上传"/>
            </td>
        </tr>
    </table>
</form>
<h2>文件下载</h2>
<c:forEach var="fileName" items="${fileNameList}">
    <p>
        <%--<a href="javascript:window.location.href='download?filename=' + encodeURIComponent('${fileName}')">${fileName}</a>--%>
        <a href="/download?filename=${fileName}">${fileName}</a>
    </p>
</c:forEach>
</body>
</html>
