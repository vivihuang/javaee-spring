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
<link type="text/css" rel="stylesheet" href="lib/css/navbar.css">
<link type="text/css" rel="stylesheet" href="lib/css/table.css">


<html>
<head>
    <title>健身房管理系统</title>
</head>

<body>
<%--<div class="logo">--%>
    <div class="logo">
        <img src="lib/images/cat.jpg">Vivi的健身房
    </div>

<div class="nav">
    <ul>
        <li class="userManagement"><a href="/web/index">首页</a>
            <ul><li><a href="/web/logout">退出登录</a></li></ul>
        </li>
        <li class="userManagement"><a href="/web/user">用户管理</a>
            <ul><li><a href="/web/user/add">增加用户</a></li>
                <li><a href="/web/user/history">查看历史用户</a></li>
            </ul>
        </li>
        <li class="userManagement"><a href="/web/customer">顾客管理</a>
            <ul><li><a href="/web/customer/add">增加顾客</a></li></ul>
        </li>
        <li class="userManagement"><a href="/web/course" >课程管理</a>
            <ul><li><a href="/web/course/add">增加课程</a></li></ul>
        </li>
        <li class="userManagement"><a href="/web/course_arrangement" >课程安排</a>
            <ul><li><a href="/web/course_arrangement/add" >增加排课</a></li></ul>
        </li>
    </ul>
</div>
<%--</div>--%>
<div>
    <table class="index">
    <ul class="welcome"><p>欢迎来到Vivi的健身房</p></ul>
    <tr><td><c:out value="课程" /></td>
        <td><c:out value="教练" /></td>
        </tr>

    <c:forEach items="${courseList}" var="course" varStatus="status">
        <tr><td><c:out value="${course.name}" /></td>
            <td><c:out value="${course.coach.name}" /></td>
            </tr>
        </c:forEach>
</table>
    </div>
  </body>
</html>
