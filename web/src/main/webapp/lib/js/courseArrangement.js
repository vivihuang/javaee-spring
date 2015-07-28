
$(document).ready(function(){
    $(".delete").on('click',function () {
        var button = $(this);
        var courseArrangementId = $(this).attr("value");
        console.log(courseArrangementId);
        $.ajax({
            url: "/web/course_arrangement/delete/"+courseArrangementId,
            type: 'DELETE',
            success: function(){
                button.closest("tr").remove();
            }
        });
    });

});
