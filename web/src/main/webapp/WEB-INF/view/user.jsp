<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/18/15
  Time: 22:23
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
  <a href="/web/user/add">增加用户</a>
  <tr align="center">
    <td><c:out value="用户名" /></td>
    <td><c:out value="密码" /></td>
    <td><c:out value="职务" /></td>
    <td colspan="2"><c:out value="操作" /></td>
  </tr>

  <c:forEach items="${userList}"  var="user" varStatus="status" >
    <tr align="center">
      <td><c:out value="${user.name}" /></td>
      <td><c:out value="${user.password}" /></td>
      <td><c:out value="${user.employee.role}" /></td>
      <td><a href="/web/user/update/<c:out value="${user.id}"/>">修改用户</a></td>
      <td><a href="/web/user/delete/<c:out value="${user.id}" />">删除用户</a></td>

    </tr>
  </c:forEach>

</table>
</body>
</html>
