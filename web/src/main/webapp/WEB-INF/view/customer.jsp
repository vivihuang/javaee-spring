<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/18/15
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<div>
    <ul class="welcome"><p>顾客列表</p></ul>
<table>
  <%--<a href="/web/customer/add">增加顾客信息</a>--%>
  <tr align="center">
    <td><c:out value="顾客姓名" /></td>
    <td><c:out value="私人教练" /></td>
    <td><c:out value="私人课程" /></td>
    <td colspan="2"><c:out value="操作" /></td>
  </tr>

  <c:forEach items="${customerList}"  var="customer" varStatus="status" >
    <tr align="center">
      <td><c:out value="${customer.name}" /></td>
      <td><c:out value="${customer.coach.name}" /></td>

      <td><a href="/web/customer/courses/<c:out value="${customer.id}" />">显示课程表</a></td>
      <td><a href="/web/customer/update/<c:out value="${customer.id}"/>">修改顾客信息</a></td>
      <td><a href="/web/customer/delete/<c:out value="${customer.id}" />">删除顾客信息</a></td>
    </tr>
  </c:forEach>

</table>
    </div>

</body>
</html>
