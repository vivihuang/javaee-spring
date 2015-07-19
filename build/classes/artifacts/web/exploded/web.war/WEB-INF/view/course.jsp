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

<html>
<head>
    <title></title>
</head>
<body>

<table border="2">
    <a href="/web/system/course/add">增加课程</a>
    <tr align="center">
        <td><c:out value="课程" /></td>
        <td><c:out value="教练" /></td>
        <td colspan="2"><c:out value="操作" /></td>
    </tr>

    <c:forEach items="${courseList}"  var="course" varStatus="status" >
        <tr align="center">
                <%--<td><c:out value="${item.id} " /></td>--%>
            <td><c:out value="${course.name}" /></td>
            <td><c:out value="${course.coach.name}" /></td>
            <td><a href="/web/system/course/update/<c:out value="${course.id}"/>">修改课程</a></td>
            <td><a href="/web/system/course/delete/<c:out value="${course.id}" />">删除课程</a></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
