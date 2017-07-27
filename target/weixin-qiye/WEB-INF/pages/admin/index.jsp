<%--
  Created by IntelliJ IDEA.
  User: zhaoxinguo
  Date: 2017/7/19
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/pages/common/basePath.jsp"></jsp:include>
<html>
<head>
    <title>后台-首页</title>
</head>
<body>
<c:if test="${names == null}">
    <a href="${basePath}/login">登录</a>
</c:if>
<c:if test="${names != null}">
    欢迎：${names} 访问！
    用户管理：<a href="${basePath}/back/users">用户管理</a>
    后台<a href="${basePath}/back/logout">退出</a>
</c:if>
<jsp:include page="main.jsp"></jsp:include>
</body>
</html>
