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
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
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
