/**
 * Created by Vivi on 7/19/15.
 */
function showAndHide(v){
    //alert(v);
    for(var i=1;i<10;i++){
        if(i==v){
            document.getElementById(v).style.display = 'block';
        }
        else {
            document.getElementById(i).style.display = 'none';
        }
    }
}