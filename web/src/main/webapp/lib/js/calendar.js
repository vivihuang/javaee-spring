
$(function() {
    $("#datepicker").datepicker();
});

$(function() {
    $("#calendar").datepicker({
        dateFormat:'yy-mm-dd',
        changeMonth : true,
        changeYear : true
    });
});


var curYear = new Date().getFullYear();
$('#calendar').datepicker({
    yearRange: curYear+':'+curYear,
    prevText: '前一月',
    nextText: '后一月',
    yearSuffix: '年',
    dateFormat: "yy-mm-dd",
    showMonthAfterYear: true,
    dayNamesMin: ['日','一','二','三','四','五','六'],
    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
    onSelect: function(text, instance){
        var arr = text.split('-');
        var year = arr[0], month = arr[1], day = arr[2];
        var curDateTime = new Date(year, month-1, day, 8, 0, 0);
        var dialogTitle = '商学院于'+text+'的课程安排';
        var curDateCourseList = [];
        var dialogHeight = 40;
        for(var i in courseList){
            var time = courseList[i].begin_date * 1000;
            if(time == curDateTime.getTime()){
                curDateCourseList.push("<a title='点击查看详情' href='/course/index.php?id="+courseList[i].id+"' target='_blank'>"+courseList[i].name+"</a>&nbsp;&nbsp;<span style='color:#888;'>地点:"+ courseList[i].address +"</span><br>");
                dialogHeight += 35;
            }
        }
        $(".dateCourseList").html(curDateCourseList.join(',')).dialog({title:dialogTitle, height:dialogHeight});
        $(".dateCourseList").dialog("open");
        return false;
    },
    beforeShowDay: function(date){
        for(var i in courseList){
            var courseTime = (courseList[i].begin_date - 60 * 60 * 8)*1000;
            if(courseTime == date.getTime()){
                return [true, 'hasCourse', '课程日'];
                break;
            }
        }
        return [false, 'noCourse', '没有课程'];
    }
});