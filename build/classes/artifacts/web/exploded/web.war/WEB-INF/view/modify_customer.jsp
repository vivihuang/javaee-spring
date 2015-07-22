<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/18/15
  Time: 23:59
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
            <ul><li><a href="/web/user/add">增加用户</a></li></ul>
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

<form method="POST" action="/web/customer">
    <ul class="welcome"><p>请增加顾客</p>
        </ul>
  <ul>顾客姓名 : <input class="input"
        type="text" name="name"
        value="<c:out value="${customer.name}" />"/>
      </ul>
  <ul>私人教练 : <select class="select" name="coach_id" onchange = "showAndHide(this.value)">
                <option value="null">请选择</option>
                <c:forEach items="${coachList}" var="coach" varStatus="status">
                    <option value= "<c:out value="${coach.id}" />">
                         <c:out value="${coach.id}. ${coach.name}" /></option>
                </c:forEach>
            </select>
      </ul>
  <input type="text" readonly="readonly" name="id" hidden="hidden"
         value="<c:out value="${customer.id}" />"/>
  <ul><input class="submit" type="submit" value="提交"/>
      </ul>
</form>

</body>
</html>
