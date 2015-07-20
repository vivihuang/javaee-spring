<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/7/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
    <table>
        <tr>
            <td><a href="/web/logout">退出登录</a></td>
        </tr>
        <tr>
            <td><a href="/web/user">用户管理</a></td>
            <td><a href="/web/customer">顾客管理</a></td>
            <td><a href="/web/course" >课程管理</a></td>
        </tr>
        <tr>
            <td><a href="/web/course_arrangement" >课程安排</a></td>
        </tr>
        <tr>
            <div datatype="date" id="datepicker" ></div>
        </tr>

    </table>

  </body>
</html>
