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