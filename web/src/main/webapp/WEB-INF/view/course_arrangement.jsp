<%@ page import="com.tw.core.entity.DateRelation" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/19/15
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="lib/css/navbar.css">
<link type="text/css" rel="stylesheet" href="lib/css/table.css">


<html>
<head>
    <title></title>
</head>
<body>

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

  <%--<tr>--%>
    <%--&lt;%&ndash;<td><a href="/web/course_arrangement/add" >增加课程</a></td>&ndash;%&gt;--%>
  <%--</tr>--%>

<div>
  <ul class="welcome"><p>课程安排</p></ul>
  <table>
    <tr>
      <td>日期</td>
      <td>课程</td>
      <td>教练</td>
      <td>顾客</td>
      <td colspan="2">操作</td>
    </tr>

    <c:forEach items="${course_arrangement_list}" var="item" varStatus="status">
      <tr>
        <td><fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd"/></td>
        <td><c:out value="${item.course.name}" /></td>
        <td><c:out value="${item.course.coach.name}" /></td>
        <td><c:out value="${item.customer.name}" /></td>
        <td><a href="/web/course_arrangement/update/<c:out value="${item.id}" />">修改课程</a></td>
        <td><a href="/web/course_arrangement/delete/<c:out value="${item.id}" />">删除课程</a></td>
      </tr>
      </c:forEach>
  </table>

</body>
</html>
