<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<head>
  <title>trytrytry</title>
  <script>
    $(function() {
      $( "#datepicker" ).datepicker();
    });

    function chooseCourseType(){
      if (document.getElementById("radio2").checked) {
          document.getElementById("customer").style.display="";
          document.getElementById("customer_name").style.display="";
      }
      else {
          document.getElementById("customer").style.display="none";
          document.getElementById("customer_name").style.display="none";
      }
    }
  </script>

</head>

<body>
    <input type="text" id="datepicker" /></br>
    课程类型：<input type="radio" id="radio1" name="course_type" onclick="chooseCourseType()" checked="checked"/>公共课程
           <input type="radio" id="radio2" name="course_type" onclick="chooseCourseType()" />私人课程
    </br>
    课程名称：<select name="course_id" onchange = "showAndHide(this.value)">
               <option value="null">请选择</option>
                  <c:forEach items="${courseList}" var="course" varStatus="status">
                    <option value= "<c:out value="${course.id}" />">
                      <c:out value="${course.name}" /></option>
                  </c:forEach>
               </select></br>
    教练姓名：<input type="text" readonly="readonly"></br>
    <div id="customer_name" style="display: none">顾客姓名：
        <input type="text" id="customer" style="display: none"/></div></br>
</body>
</html>