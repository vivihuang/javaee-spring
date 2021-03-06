<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/19/15
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

    <script language="JavaScript" src="/web/lib/js/jquery-1.11.1.min.js"></script>
    <script src="/web/lib/js/jquery-ui/external/jquery/jquery.js"></script>
    <script src="/web/lib/js/jquery-ui/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="/web/lib/js/jquery-ui/jquery-ui.min.css">
    <script src="/web/lib/js/modifyCourseArrangement.js"></script>
    <link type="text/css" rel="stylesheet" href="/web/lib/css/navbar.css">
    <link type="text/css" rel="stylesheet" href="/web/lib/css/form.css">

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

<div class="welcome">
    <p>请增加课程安排</p>
    </div>

  <form id="add_form" method="POST" action="/web/course_arrangement" >

      <div>课程日期：<input class="input" type="text" id="date" name="date"/></div>

      <div>课程类型：<input class="radio" type="radio" id="radio_public" name="course_type" value="public" onclick="chooseCourseType()" checked="checked"/>公共课程
                <input class="radio" type="radio" id="radio_personal" name="course_type" value="personal" onclick="chooseCourseType()" />私人课程
      </div></br>

      <div id="personal" style="display: none">
          顾客姓名：<select class="select" id="customer_select" name="customer_id" onchange="showPersonalCoachName()">
                    <option value="null" selected="selected">请选择</option>
                        <c:forEach items="${customerList}" var="customer" varStatus="status">
                            <option name="${customer.coach.name}" value="<c:out value="${customer.id}" />">
                                <c:out value="${customer.name}" /></option>
                        </c:forEach></select></br>
          教练姓名：<input class="input" id="personal_coach_name" name="coach_name">
      </div>

      <div id="public">
          课程名称：<select class="select" id="public_course_select" name="course_id" onchange="showPublicCoachName()">
                    <option value="null" selected="selected">请选择</option>
                        <c:forEach items="${courseList}" var="course" varStatus="status" >
                            <option <c:if test="${course.name=='私教课'}">hidden="hidden"</c:if>
                                    name="${course.coach.name}" value= "<c:out value="${course.id}"/>">
                                    <c:out value="${course.name}" /></option>
                        </c:forEach></select></br>
          教练姓名：<input class="input" id="public_coach_name" type="text" readonly="readonly" name="coach_name"></br>
      </div>

      <input type="text" readonly="readonly" name="id" hidden="hidden"
           value="<c:out value="${dateRelation.id}" />"/>

      <input class="submit" type="submit" value="提交" />
  </form>

</body>
</html>