<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/13/15
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.tw.core.util.MD5Util" %>
<jsp:useBean id='MD5' scope='request' class='com.tw.core.util.MD5Util'/>
<html>
<head>
    <title></title>
</head>

<body>
    <form method="POST" action="/web/login" name="login">
        <table width="300" border="0">
            <tr>
                <td align="center">用户名：</td>
                <td><input name="inputName" type="text" size="20"></td>
            </tr>
            <tr>
                <td align="center">密  码：</td>
                <td><input name="inputPassword" type="text" size="20"/></td>
            </tr>
            <td align="center"><input type="submit" value="提交"/></td>
        </table>
    </form>
</body>

</html>
