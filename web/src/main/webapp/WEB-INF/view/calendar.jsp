<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="javascript">
    function showandhide(v){
      //alert(v);
      for(i=1;i<3;i++){
        document.getElementById(i).style.display = 'none';
        if(i==v){
          document.getElementById(v).style.display = 'block';
        }
      }
    }
  </script>
  <title>js 下拉框控制div的显示</title>
</head>

<body>
<select name="select" onchange = "showandhide(this.value)">
  <option value="1">xxxx</option>
  <option value="2">yyyy</option>
</select>
<div id="1">xxxx</div>
<div id="2" style="display:none;">yyyy</div>
</body>
</html>