/**
 * Created by Vivi on 7/27/15.
 */
$(document).ready(function() {
    $(".updateButton").on('click',function() {
        var courseId = $(this).attr("value");
        var tr= $(this).closest('tr');
        var options = tr.find("select").find("option");
        options.each(function () {
            if ($(this).val() == courseId) {
                $(this).attr("selected",true);
            }
        });
        tr.find("td.update").hide();
        tr.find("td.confirmUpdate").show();
    });

    $(".confirmUpdateButton").on('click',function(){
        var button = $(this);
        var tr = button.closest("tr");
        var courseName = tr.find("input#nameUpdateInput").val();
        var coachId = tr.find("select").find("option:selected").attr("name");
        var courseId = tr.find("select").find("option:selected").attr("value");
        $.ajax({
            url:"/web/course",
            type: 'POST',
            data: {"id":courseId,"courseName":courseName,"coachId":coachId},
            dataType:"json",
            success: function(course){
                tr.find("td.update").show();
                tr.find("td.confirmUpdate").hide();
                tr.find("td#courseName").text(course.name);
                tr.find("td#coachName").text(course.coach.name);
            },
            error: function(data){
                console.log(data);
                alert("Operation failed!");
            }
        });
    });
});