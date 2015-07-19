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
<script type="text/javascript" src="js/ShowAndHide.js"></script>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="/web/system/customer">
  顾客姓名 : <input
        type="text" name="name"
        value="<c:out value="${customer.name}" />"/> <br/>
  私人教练 : <select name="coach_id" onchange = "showAndHide(this.value)">
                <option value="null">请选择</option>
                <c:forEach items="${coachList}" var="coach" varStatus="status">
                    <option value= "<c:out value="${coach.id}" />">
                         <c:out value="${coach.id}. ${coach.name}" /></option>
                </c:forEach>
            </select>
  <%--私人课程 : <input--%>
        <%--type="text" name="role"--%>
        <%--value="<c:out value="${customer.courseList}" />"/> <br/>--%>
  <input type="text" readonly="readonly" name="id" hidden="hidden"
         value="<c:out value="${customer.id}" />"/>
  <input type="submit" value="提交"/>
</form>

</body>
</html>
