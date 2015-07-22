<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/7/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="./lib/css/navbar.css">

<html>
<head>
    <title>健身房管理系统</title>
</head>

<body>
<%--<div class="logo">--%>
    <div class="logo">
        <img src="./lib/images/cat.jpg">Vivi的健身房
    </div>

    <div class="nav">
        <ul>
            <li><a href="/web/index">首页</a></li>
            <li class="userManagement"><a href="/web/user">用户管理</a>
                <ul>
                    <li><a href="/web/logout">退出登录</a></li>
                    <li><a href="/web/user/add">增加用户</a></li>
                </ul></li>
            <li><a href="/web/customer">顾客管理</a></li>
            <li><a href="/web/course" >课程管理</a></li>
            <li><a href="/web/course_arrangement" >课程安排</a></li>
        </ul>
    </div>
<%--</div>--%>

  </body>
</html>
