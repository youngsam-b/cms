/*var contextRoot='/cms/';*/
/*
$(document).ready(function () {

    $.fx.speeds._default = 1000;
    $("#dialog-form").dialog({
        autoOpen: false,
        show: 'blind',
        hide: 'explode',
        height: 300,
        width: 350,
        modal: true
    });
    $("#dialog-form").children('img').css('display', 'none');

    $(document).ajaxStart(function () {
        $("#dialog-form ").children('img').css('display', 'block');
        $(".ui-dialog-titlebar").hide();
        $("#dialog-form").dialog('open');
    });

    $(document).ajaxStop(function () {
        $("#dialog-form").dialog('close');
        $("#dialog-form ").children('img').css('display', 'none');
    });
});
*/

function noSpecialChar(e) {

    var key;
    if (window.event) {
        key = window.event.keyCode; //IE
    }
    else {
        key = e.which; //firefox
    }

    //alert(key);
    if (!((key > 64 && key <= 90) || (key > 96 && key <= 122) || (key == 32) || (key > 47 && key <= 57) || (key == 8) || (key == 0) || (key == 127)
        || (key == 33) || (key == 46) || (key == 63)
    
    )) {
        //alert(" You can enter only characters a to z,A to Z,0 to 9, and Space  ");
        return false;
    }
    else 
    return true;
}


