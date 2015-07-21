<%@ page import="java.util.List" %>
<%@ page import="com.tw.core.entity.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tw.core.entity.Course" %>
<%--
  Created by IntelliJ IDEA.
  User: Vivi
  Date: 7/19/15
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<html>
<head>
    <script type="text/javascript">
        $(function() {
            $("#datepicker").datepicker({
                dateFormat:'yy-mm-dd',
                changeMonth : true,
                changeYear : true
            });
        });

        function showPublicCoachName() {
            var name = $('#public_course_select').find("option:selected").attr("name");
            $("#public_coach_name").val(name);
        }

        function showPersonalCoachName(){
            var name = $('#customer_select').find("option:selected").attr("name");
            $("#personal_coach_name").val(name);
        }

        function chooseCourseType(){
            if (document.getElementById("radio_personal").checked) {
                document.getElementById("personal").style.display="";
                document.getElementById("public").style.display="none";
            }
            else {
                document.getElementById("personal").style.display="none";
                document.getElementById("public").style.display="";
            }
        }

    </script>
    <title></title>
</head>
<body>

  <form id="add_form" method="POST" action="/web/course_arrangement" >

      <div>课程日期：<input type="text" id="datepicker" name="date"/></div></br>

      <div>课程类型：<input type="radio" id="radio_public" name="course_type" value="public" onclick="chooseCourseType()" checked="checked"/>公共课程
                <input type="radio" id="radio_personal" name="course_type" value="personal" onclick="chooseCourseType()" />私人课程
      </div></br>

      <div id="personal" style="display: none">
          顾客姓名：<select id="customer_select" name="customer_id" onchange="showPersonalCoachName()">
                    <option value="null" selected="selected">请选择</option>
                        <c:forEach items="${customerList}" var="customer" varStatus="status">
                            <option name="${customer.coach.name}" value="<c:out value="${customer.id}" />">
                                <c:out value="${customer.name}" /></option>
                        </c:forEach></select></br>
          教练姓名：<input id="personal_coach_name" name="coach_name">
      </div>

      <div id="public">
          课程名称：<select id="public_course_select" name="course_id" onchange="showPublicCoachName()">
                    <option value="null" selected="selected">请选择</option>
                        <c:forEach items="${courseList}" var="course" varStatus="status" >
                            <option <c:if test="${course.name=='私教课'}">hidden="hidden"</c:if>
                                    name="${course.coach.name}" value= "<c:out value="${course.id}"/>">
                                    <c:out value="${course.name}" /></option>
                        </c:forEach></select></br>
          教练姓名：<input id="public_coach_name" type="text" readonly="readonly" name="coach_name"></br>
      </div>

      <input type="text" readonly="readonly" name="id" hidden="hidden"
           value="<c:out value="${dateRelation.id}" />"/>

      <input type="submit" value="提交" />
  </form>

</body>
</html>