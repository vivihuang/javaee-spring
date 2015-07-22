<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/13/15
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id='MD5' scope='request' class='com.tw.core.util.MD5Util'/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/navbar.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/form.css">


<html>
<head>
    <title></title>
</head>

<body>
<div class="logo">
    <img src="<%=request.getContextPath()%>/lib/images/cat.jpg">Vivi的健身房
</div>

<div>
    <ul class="loginWelcome"><p>欢迎来到Vivi的健身房，请登录</p></ul>
    <form method="POST" action="/web/login" name="login">
        <ul>用户：<input class="input" name="inputName" type="text" size="20" />
            </ul>
        <ul>密  码：<input class="input" name="inputPassword" type="text" size="20"/>
            </ul>
        <ul><input class="submit" type="submit" value="提交"/>
            </ul>
    </form>

    <table border="4">
        <tr align="center">
            <%--<td><c:out value="编号" /></td>--%>
            <td><c:out value="姓名" /></td>
        </tr>

        <c:forEach items="${userList}"  var="item" varStatus="status" >
            <tr align="center">
                    <%--<td><c:out value="${item.id} " /></td>--%>
                <td><c:out value="${item.name}" /></td>
                <td><a href="/web/users/update/<c:out value="${item.id}"/>">修改</a></td>
                <td><a href="/web/users/delete/<c:out value="${item.id}" />">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>

</html>
