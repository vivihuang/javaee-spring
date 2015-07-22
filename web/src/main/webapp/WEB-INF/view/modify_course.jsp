<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/18/15
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link type="text/css" rel="stylesheet" href="./lib/css/navbar.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
<div class="logo">
    <img src="./lib/images/cat.jpg">Vivi的健身房
</div>

<div class="nav">
    <ul>
        <li><a href="/web/index">首页</a></li>
        <li class="userManagement"><a href="/web/user">用户管理</a>
            <ul>
                <li><a href="/web/logout">退出登录</a></li>
                <li><a href="#">增加用户</a></li>
            </ul></li>
        <li><a href="/web/customer">顾客管理</a></li>
        <li><a href="/web/course" >课程管理</a></li>
        <li><a href="/web/course_arrangement" >课程安排</a></li>
    </ul>
</div>

<form method="POST" action="/web/course">
  课程 : <input
        type="text" name="course_name"
        value="<c:out value="${course.name}" />"/> <br/>
  教练 : <select name="coach_id" onchange = "showAndHide(this.value)">
            <c:forEach items="${coachList}" var="coach" varStatus="status">
                <option value= "<c:out value="${coach.id}" />">
                    <c:out value="${coach.id}. ${coach.name}" /></option>
            </c:forEach>
        </select>
  <input type="text" readonly="readonly" name="id" hidden="hidden"
         value="<c:out value="${course.id}" />"/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>
