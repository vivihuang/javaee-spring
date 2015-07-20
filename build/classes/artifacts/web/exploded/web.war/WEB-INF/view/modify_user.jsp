<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/8/15
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="/ShowAndHide.js"></script>
<html>
<head>
    <title></title>
</head>

<body>
<form method="POST" action="/web/user">
  用户名 : <input
        type="text" name="name"
        value="<c:out value="${user.name}" />"/> <br/>
  密码 : <input
        type="text" name="password"
        value="<c:out value="${user.password}" />"/> <br/>
  <%--职务 : <input--%>
        <%--type="text" name="role"--%>
        <%--value="<c:out value="${user.employee.role}" />"/> <br/>--%>
    职务：<select name="role" onchange = "showAndHide(this.value)">
            <option value= "hr" >hr</option>
            <option value="op" >op</option>
            <option value="coach">coach</option>
        </select>
  <input type="text" readonly="readonly" name="id" hidden="hidden"
         value="<c:out value="${user.id}" />"/>
  <input type="submit" value="提交"/>
</form>

</body>
</html>