<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/7/19
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>前台-首页</title>
</head>
<body>
<c:if test="${name == null}">
    <a href="/login">登录</a>
</c:if>
<c:if test="${name != null}">
    欢迎：${name} 访问！
    个人信息：<a href="/user/userInfo">个人信息</a>
    前台<a href="/user/logout">退出</a>
</c:if>
<jsp:include page="main.jsp"></jsp:include>
</body>
</html>
