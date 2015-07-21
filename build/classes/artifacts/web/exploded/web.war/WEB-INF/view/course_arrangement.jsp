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
<html>
<head>
    <title></title>
</head>
<body>
  <tr>
    <td><a href="/web/course_arrangement/add" >增加课程</a></td>
  </tr>

  <table border="2">
    <tr>
      <td>日期</td>
      <td>课程</td>
      <td>教练</td>
      <td>顾客</td>
      <td colspan="2">操作</td>
    </tr>

    <c:forEach items="${course_arrangement_list}" var="item" varStatus="status">
      <%--<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");%>--%>
      <tr>
        <td><c:out value="${item.date}" /></td>
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
