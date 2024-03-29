<%--
  Created by IntelliJ IDEA.
  User: zhaoxinguo
  Date: 2017/7/7
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/WEB-INF/pages/common/basePath.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>前台-登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${basePath}/static/layui/res/layui/css/layui.css">
    <link rel="stylesheet" href="${basePath}/static/layui/res/css/global.css">
</head>
<body>
<%--<form action="${basePath}/user/login" method="post">
    <input type="text" id="name" name="name">用户名<br/>
    <input type="password" id="password" name="password">密码<br/>
    <input type="submit" value="登录">
</form>--%>
<div class="header">
    <div class="main">
        <a class="logo" href="/" title="Fly">Fly社区</a>
        <div class="nav">
            <a class="nav-this" href="index.html">
                <i class="iconfont icon-wenda"></i>问答
            </a>
            <%--<a href="http://www.layui.com/" target="_blank">
                <i class="iconfont icon-ui"></i>框架
            </a>--%>
        </div>

        <div class="nav-user">
            <!-- 登入后的状态 -->
            <c:if test="${name != null}">
                <a class="avatar" href="../user/index.html">
                    <img src="http://tp4.sinaimg.cn/1345566427/180/5730976522/0">
                    <cite>贤心</cite>
                    <i>VIP2</i>
                </a>
                <div class="nav">
                    <a href="../user/set.html"><i class="iconfont icon-shezhi"></i>设置</a>
                    <a href=""><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退了</a>
                </div>
            </c:if>
        </div>
    </div>
</div>

<div class="main layui-clear">

    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">登入</li>
                <li><a href="${basePath}/register">注册</a></li>
            </ul>
            <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form method="post" action="${basePath}/user/login">
                            <div class="layui-form-item">
                                <label for="L_email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="pass" required lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_vercode" class="layui-form-label">人类验证</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">
                                    <span style="color: #c00;">1+1=?</span>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" lay-filter="*" lay-submit>立即登录</button>
                                <span style="padding-left:20px;">
                  <a href="forget.html">忘记密码？</a>
                </span>
                            </div>
                            <%--<div class="layui-form-item fly-form-app">
                                <span>或者使用社交账号登入</span>
                                <a href="http://fly.layui.com:8098/app/qq" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                                <a href="http://fly.layui.com:8098/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
                            </div>--%>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div class="footer">
    <p><a href="http://fly.layui.com/">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/">layui.com</a></p>
    <p>
        <a href="http://fly.layui.com/auth/get" target="_blank">产品授权</a>
        <a href="http://fly.layui.com/jie/8157.html" target="_blank">获取Fly社区模版</a>
        <a href="http://fly.layui.com/jie/2461.html" target="_blank">微信公众号</a>
    </p>
</div>
<script src="${basePath}/static/layui/res/layui/layui.js"></script>
<script>
    layui.cache.page = 'user';
    layui.cache.user = {
        username: '游客'
        ,uid: -1
        ,avatar: '${basePath}/static/layui/res/images/avatar/00.jpg'
        ,experience: 83
        ,sex: '男'
    };
    layui.config({
        version: "2.0.0"
        ,base: '${basePath}/static/layui/res/mods/'
    }).extend({
        fly: 'index'
    }).use('fly');
</script>
</body>
</html>
