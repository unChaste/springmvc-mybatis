<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>说说</title>
    <script src="https://lib.baomitu.com/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<h2>说说列表</h2>
<c:forEach var="mood" items="${moodList}">
    <p>
        用户：${mood.userName}<br/>
        说说内容：${mood.content}<br/>
        发表时间：<fmt:formatDate value="${mood.publishTime}" pattern="yyyy-MM-dd hh:mm:ss"/><br/>
        点赞数：${mood.praiseNum}<br/>
        <c:choose>
            <c:when test="${mood.hasPraised}">
                <a id="praise" href="/mood/unpraise?moodId=${mood.id}&userId=${user.id}">已赞</a>
            </c:when>
            <c:otherwise>
                <a id="praise" href="/mood/praise?moodId=${mood.id}&userId=${user.id}">赞</a>
            </c:otherwise>
        </c:choose>
    </p>
</c:forEach>
<script>

</script>
</body>
</html>
