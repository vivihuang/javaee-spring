<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/18/15
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script language="JavaScript" src="/web/lib/js/jquery-1.11.1.min.js"></script>
    <link type="text/css" rel="stylesheet" href="/web/lib/css/navbar.css">
    <link type="text/css" rel="stylesheet" href="/web/lib/css/table.css">
    <script src="/web/lib/js/course.js"></script>
    <title></title>
</head>
<body>

<div class="logo">
    <img src="/web/lib/images/cat.jpg">Vivi的健身房
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
<table>
    <%--<a href="/web/course/add">增加课程</a>--%>
    <ul class="welcome"><p>课程列表</p></ul>
    <tr align="center">
        <td><c:out value="课程" /></td>
        <td><c:out value="教练" /></td>
        <td colspan="2"><c:out value="操作" /></td>
    </tr>

    <c:forEach items="${courseList}"  var="course" varStatus="status" >
        <tr align="center">
                <%--<td><c:out value="${item.id} " /></td>--%>
            <td class="update" id="courseName"><c:out value="${course.name}" /></td>
            <td class="confirmUpdate" hidden="hidden"><input id="nameUpdateInput" type="text" value="${course.name}" /></td>
            <td class="update" id="coachName"><c:out value="${course.coach.name}" /></td>
            <td class="confirmUpdate" hidden="hidden">
                <select class="select" name="coach_id">
                    <c:forEach items="${coachList}" var="coach" varStatus="status">
                        <option name="${coach.id}" value="<c:out value="${course.id}" />"><c:out value="${coach.id}. ${coach.name}" /></option>
                    </c:forEach>
                </select>
            </td>
            <td class="update" ><button class="updateButton" value="${course.id}">修改课程</button></td>
            <td  class="confirmUpdate" hidden="hidden"><button class="confirmUpdateButton">确认修改</button></td>
            <td><a href="/web/course/delete/<c:out value="${course.id}" />">删除课程</a></td>
        </tr>
    </c:forEach>

</table>
    </div>
</body>
</html>
