<%--
  Created by IntelliJ IDEA.
  User: zhaoxinguo
  Date: 2017/7/7
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台-登录</title>
</head>
<body>
<form action="/back/login" method="post">
    <input type="text" id="name" name="name">用户名<br/>
    <input type="password" id="password" name="password">密码<br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
