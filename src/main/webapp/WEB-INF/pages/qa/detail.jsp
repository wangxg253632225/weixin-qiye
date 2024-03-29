<%--
  Created by IntelliJ IDEA.
  User: zhaoxinguo
  Date: 2017/7/27
  Time: 18:13
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
    <title>前台-问答详情</title>
    <title>Fly Template v2.0，基于 layui 的轻量级社区模版</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${basePath}/static/layui/res/layui/css/layui.css">
    <link rel="stylesheet" href="${basePath}/static/layui/res/css/global.css">
</head>
<body>

<div class="header">
    <div class="main">
        <a class="logo" href="/" title="Fly">Fly社区</a>
        <div class="nav">
            <a class="nav-this" href="${basePath}/index">
                <i class="iconfont icon-wenda"></i>问答
            </a>
            <%--<a href="http://www.layui.com/" target="_blank">
                <i class="iconfont icon-ui"></i>框架
            </a>--%>
        </div>

        <div class="nav-user">
            <!-- 未登入状态 -->
            <a class="unlogin" href="user/login.html"><i class="iconfont icon-touxiang"></i></a>
            <span><a href="${basePath}/login">登入</a><a href="${basePath}/register">注册</a></span>
            <%--<p class="out-login">
                <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
            </p>--%>

            <!-- 登入后的状态 -->
            <c:if test="${name != null}">
            <a class="avatar" href="user/index.html">
              <img src="http://tp4.sinaimg.cn/1345566427/180/5730976522/0">
              <cite>贤心</cite>
              <i>VIP2</i>
            </a>
            <div class="nav">
              <a href="/user/set/"><i class="iconfont icon-shezhi"></i>设置</a>
              <a href="/user/logout/"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退了</a>
            </div>
            </c:if>

        </div>
    </div>
</div>


<div class="main layui-clear">
    <div class="wrap">
        <div class="content detail">
            <div class="fly-panel detail-box">
                <h1>Fly Template v2.0，基于 layui 的轻量级社区模版</h1>
                <div class="fly-tip fly-detail-hint" data-id="{{rows.id}}">
                    <span class="fly-tip-stick">置顶帖</span>
                    <span class="fly-tip-jing">精帖</span>

                    <span>未结贴</span>
                    <!-- <span class="fly-tip-jie">已采纳</span> -->

                    <!-- <span class="jie-admin" type="del" style="margin-left: 20px;">删除</span>
                    <span class="jie-admin" type="set" field="stick" rank="1">置顶</span>
                    <span class="jie-admin" type="set" field="stick" rank="0" style="background-color:#ccc;">取消置顶</span>
                    <span class="jie-admin" type="set" field="status" rank="1">加精</span>
                    <span class="jie-admin" type="set" field="status" rank="0" style="background-color:#ccc;">取消加精</span> -->

                    <div class="fly-list-hint">
                        <i class="iconfont" title="回答">&#xe60c;</i> 517
                        <i class="iconfont" title="人气">&#xe60b;</i> 98032
                    </div>
                </div>
                <div class="detail-about">
                    <a class="jie-user" href="">
                        <img src="http://tp4.sinaimg.cn/1345566427/180/5730976522/0" alt="">
                        <cite>
                            贤心
                            <em>1分钟前发布</em>
                        </cite>
                    </a>
                    <div class="detail-hits" data-id="{{rows.id}}">
                        <span style="color:#FF7200">悬赏：20飞吻</span>
                        <span class="layui-btn layui-btn-mini jie-admin" type="edit"><a href="/jie/edit/{{rows.id}}">编辑此贴</a></span>
                        <span class="layui-btn layui-btn-mini jie-admin " type="collect" data-type="add">收藏</span>
                        <!--<span class="layui-btn layui-btn-mini jie-admin  layui-btn-danger" type="collect" data-type="add">取消收藏</span>-->
                    </div>
                </div>

                <div class="detail-body photos" style="margin-bottom: 20px;">
                    <p>
                        该模版由 layui官方社区（<a href="http://fly.layui.com/" target="_blank">fly.layui.com</a>）倾情提供，只为表明我们对 layui 执着的信念、以及对未来持续加强的承诺。该模版基于 layui 搭建而成，可作为简约型问答社区的页面支撑。
                    </p>
                    <p>更新日志：</p>
                    <pre>
# v2.0 2017-03-15
* 采用 layui 1.0.9_rls 作为UI支撑
* 所有页面更换为卡片式布局
* 首页增加置顶板块
* Detail页增加收藏按钮
* 用户中心改造，增加左侧导航
* 消息中心、登入、注册、找回密码等页面UI升级
</pre>
                    <p>
                        码云：<a href="http://git.oschina.net/sentsin/fly" target="_blank">http://git.oschina.net/sentsin/fly</a>
                        <br>GitHub：<a href="https://github.com/layui/fly" target="_blank">https://github.com/layui/fly</a>
                    </p>
                    <p>
                        <img src="../../res/images/fly.jpg" alt="Fly社区">
                    </p>
                </div>
            </div>

            <div class="fly-panel detail-box" style="padding-top: 0;">
                <a name="comment"></a>
                <ul class="jieda photos" id="jieda">
                    <li data-id="12" class="jieda-daan">
                        <a name="item-121212121212"></a>
                        <div class="detail-about detail-about-reply">
                            <a class="jie-user" href="">
                                <img src="../../res/images/avatar/default.png" alt="">
                                <cite>
                                    <i>纸飞机</i>
                                    <!-- <em>(楼主)</em>
                                    <em style="color:#5FB878">(管理员)</em>
                                    <em style="color:#FF9E3F">（活雷锋）</em>
                                    <em style="color:#999">（该号已被封）</em> -->
                                </cite>
                            </a>
                            <div class="detail-hits">
                                <span>3分钟前</span>
                            </div>
                            <i class="iconfont icon-caina" title="最佳答案"></i>
                        </div>
                        <div class="detail-body jieda-body">
                            <p>么么哒</p>
                        </div>
                        <div class="jieda-reply">
                            <span class="jieda-zan zanok" type="zan"><i class="iconfont icon-zan"></i><em>12</em></span>
                            <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span>
                            <!-- <div class="jieda-admin">
                              <span type="edit">编辑</span>
                              <span type="del">删除</span>
                              <span class="jieda-accept" type="accept">采纳</span>
                            </div> -->
                        </div>
                    </li>

                    <li data-id="13">
                        <a name="item-121212121212"></a>
                        <div class="detail-about detail-about-reply">
                            <a class="jie-user" href="">
                                <img src="../../res/images/avatar/default.png" alt="">
                                <cite>
                                    <i>香菇</i>
                                    <em style="color:#FF9E3F">活雷锋</em>
                                </cite>
                            </a>
                            <div class="detail-hits">
                                <span>刚刚</span>
                            </div>
                        </div>
                        <div class="detail-body jieda-body">
                            <p>蓝瘦</p>
                        </div>
                        <div class="jieda-reply">
                            <span class="jieda-zan" type="zan"><i class="iconfont icon-zan"></i><em>0</em></span>
                            <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span>
                            <div class="jieda-admin">
                                <span type="edit">编辑</span>
                                <span type="del">删除</span>
                                <span class="jieda-accept" type="accept">采纳</span>
                            </div>
                        </div>
                    </li>

                    <!-- <li class="fly-none">没有任何回答</li> -->
                </ul>

                <div class="layui-form layui-form-pane">
                    <form action="/jie/reply/" method="post">
                        <div class="layui-form-item layui-form-text">
                            <div class="layui-input-block">
                                <textarea id="L_content" name="content" required lay-verify="required" placeholder="我要回答"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="hidden" name="jid" value="{{rows.id}}">
                            <button class="layui-btn" lay-filter="*" lay-submit>提交回答</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="edge">
        <dl class="fly-panel fly-list-one">
            <dt class="fly-panel-title">最近热帖</dt>
            <dd>
                <a href="">使用 layui 秒搭后台大布局（基本结构）</a>
                <span><i class="iconfont">&#xe60b;</i> 6087</span>
            </dd>
            <dd>
                <a href="">Java实现LayIM后端的核心代码</a>
                <span><i class="iconfont">&#xe60b;</i> 767</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局（基本结构）</a>
                <span><i class="iconfont">&#xe60b;</i> 6087</span>
            </dd>
            <dd>
                <a href="">Java实现LayIM后端的核心代码</a>
                <span><i class="iconfont">&#xe60b;</i> 767</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局（基本结构）</a>
                <span><i class="iconfont">&#xe60b;</i> 6087</span>
            </dd>
            <dd>
                <a href="">Java实现LayIM后端的核心代码</a>
                <span><i class="iconfont">&#xe60b;</i> 767</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局（基本结构）</a>
                <span><i class="iconfont">&#xe60b;</i> 6087</span>
            </dd>
            <dd>
                <a href="">Java实现LayIM后端的核心代码</a>
                <span><i class="iconfont">&#xe60b;</i> 767</span>
            </dd>
        </dl>

        <dl class="fly-panel fly-list-one">
            <dt class="fly-panel-title">近期热议</dt>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
            <dd>
                <a href="">使用 layui 秒搭后台大布局之基本结构</a>
                <span><i class="iconfont">&#xe60c;</i> 96</span>
            </dd>
        </dl>
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
<script src="../../res/layui/layui.js"></script>
<script>
    layui.cache.page = 'jie';
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
    }).use('fly', function(){
        var fly = layui.fly;
        //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
        /*
         $('.detail-body').each(function(){
         var othis = $(this), html = othis.html();
         othis.html(fly.content(html));
         });
         */
    });
</script>
</body>
</html>
