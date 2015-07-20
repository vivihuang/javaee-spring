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
                dateFormat:'yymmdd',
                changeMonth : true,
                changeYear : true
            });
        });

        function showCoachName(select) {
            var name = $('#course_select').find("option:selected").attr("name");
            $("#coach_name").val(name);
        }

        function chooseCourseType(){
            if (document.getElementById("radio_personal").checked) {
                document.getElementById("customer").style.display="";
            }
            else {
                document.getElementById("customer").style.display="none";
            }
        }
    </script>
    <title></title>
</head>
<body>

  <form method="POST" action="/web/course_arrangement">

      <div><input type="text" id="datepicker" name="date"/></div></br>

      <div>课程类型：<input type="radio" id="radio_public" name="course_type" onclick="chooseCourseType()" checked="checked"/>公共课程
                <input type="radio" id="radio_personal" name="course_type" onclick="chooseCourseType()" />私人课程
      </div></br>

      <div id="customer" style="display: none">顾客姓名：
          <select id="customer_id" name="customer_id">
              <option value="null" selected="selected">请选择</option>
              <c:forEach items="${customerList}" var="customer" varStatus="status">
                  <option value="<c:out value="${customer.id}" />">
                      <c:out value="${customer.name}" /></option>
              </c:forEach></select>
      </div></br>

      <div>课程名称：<select id="course_select" name="course_id" onchange="showCoachName(this)">
            <option value="null" selected="selected">请选择</option>
            <c:forEach items="${courseList}" var="course" varStatus="status">
                <option name="${course.coach.name}" value= "<c:out value="${course.id}" />">
                    <c:out value="${course.name}" /></option>
            </c:forEach></select>
      </div></br>

      <div>教练姓名：<input id="coach_name" type="text" readonly="readonly"></div></br>

      <input type="text" readonly="readonly" name="id" hidden="hidden"
           value="<c:out value="${dateCourse.id}" />"/>

      <input type="submit" value="提交" />
  </form>

</body>
</html>