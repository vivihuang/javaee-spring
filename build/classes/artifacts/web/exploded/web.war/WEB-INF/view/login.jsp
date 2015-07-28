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

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/web/lib/css/navbar.css"/>
    <link type="text/css" rel="stylesheet" href="/web/lib/css/form.css">

    <title></title>
</head>

<body>
<div class="logo">
    <img src="/web/lib/images/cat.jpg">Vivi的健身房
</div>

<div>
    <ul class="loginWelcome"><p>欢迎来到Vivi的健身房，请登录</p></ul>
    <form method="POST" action="/web/login" name="login">
        <ul>用户：<input class="input" name="inputName" type="text" size="20" />
            </ul>
        <ul>密码：<input class="input" name="inputPassword" type="text" size="20"/>
            </ul>
        <ul><input class="submit" type="submit" value="登录"/>
            </ul>
    </form>
    </div>
</body>

</html>
