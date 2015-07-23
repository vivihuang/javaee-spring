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
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/navbar.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/form.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
<div class="logo">
    <img src="<%=request.getContextPath()%>/lib/images/cat.jpg">Vivi的健身房
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

<div class="welcome">
    <p>请增加课程</p>
    </div>
<div>
<form method="POST" action="/web/course">
  <ul class="text">课程 :
      <input class="input"
        type="text" name="course_name"
        value="<c:out value="${course.name}" />"/>
      </ul>
  <ul class="text">教练 :
      <select class="select" name="coach_id">
          <option selected>请选择</option>
            <c:forEach items="${coachList}" var="coach" varStatus="status">
                <option value= "<c:out value="${coach.id}" />">
                    <c:out value="${coach.id}. ${coach.name}" /></option>
            </c:forEach>
        </select>
      </ul>
  <ul class="text"><input type="text" readonly="readonly" name="id" hidden="hidden"
         value="<c:out value="${course.id}" />"/>
      </ul>
  <ul class="text"><input class="submit" type="submit" value="提交"/>
      </ul>
</form>
    </div>
</body>
</html>
