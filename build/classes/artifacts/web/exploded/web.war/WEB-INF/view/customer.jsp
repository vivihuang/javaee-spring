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
<html>
<head>
    <title></title>
</head>
<body>

<table border="2">
  <a href="/web/system/customer/add">增加顾客信息</a>
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

      <%--<c:forEach items="${customer.courseList}" var="course" varStatus="status">--%>
        <%--<tr>--%>
          <%--<td><c:out value="${course.name}" /></td>--%>
          <%--</tr>--%>
        <%--</c:forEach>--%>
      <td><a href="/web/system/customer/courses">显示课程表</a></td>
      <td><a href="/web/system/customer/update/<c:out value="${customer.id}"/>">修改顾客信息</a></td>
      <td><a href="/web/system/customer/delete/<c:out value="${customer.id}" />">删除顾客信息</a></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
