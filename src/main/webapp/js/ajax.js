var selectionsUser = [];
function deleteMessage(index) {

    $.ajax({

        url: 'deleteMessage?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {
            location.reload();
        }

    })

}
//----------------------------------------------------------------change role on "wasRead"--------------------
function wasRead(index) {
    var allRead = "";
    var allNoRead = "";
    $.ajax({

        url: 'wasRead?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {
            onRead();
            wasReadL();
        }
    })

}
//----------------------------------------------------------------change role on "wasRead"--------------------
function wasReadL() {

    $
        .ajax({

            url: 'loadMessagesWasRead?' + $('input[name=csrf_name]').val()
            + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (res) {
                var allRead = "";
                for (var i = 0; i < res.length; i++) {

                    // alert("update wasRead");
                    allRead += "<button class=\"profilebutton\"";
                    allRead += "onclick=\"document.getElementById('message"
                        + res[i].id + "').style.display='block';\"";
                    allRead += "style=\"\">" + res[i].name + "</button>	";
                    // allRead += "<a href='#' onclick='deleteMessage('" + index + "')'>&times;</a>";

                }
                document.getElementById("wasreadmessagebutton").innerHTML = allRead;
            }
        })

}

//-----------------------------------------------------------------------all new messages---------------------
function onRead() {
    var allNoRead = "";
    $
        .ajax({

            url: 'loadMessagesoneread?' + $('input[name=csrf_name]').val()
            + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (res) {

                for (var i = 0; i < res.length; i++) {
                    // alert("update onRead");
                    allNoRead += "<button class=\"profilebutton\"";
                    allNoRead += "onclick=\"document.getElementById('message"
                        + res[i].id
                        + "').style.display='block';wasRead("
                        + res[i].id + ")\"";
                    allNoRead += "	style=\"\">" + res[i].name
                        + "</button>	";

                }
                document.getElementById("onreadmessagebutton").innerHTML = allNoRead;
            }
        })

}

// ==============================================================================================================
// ==============================================================================================================
// ==============================================================================================================
// ==============================================================================================================

//-------------------------------------------------build message body -----------------------------------
function messageSave() {

    var user = {

        name: document.getElementById('nameUser').value,
        email: document.getElementById('emailBot').value,
        message: document.getElementById('message').value

    }

    document.getElementById('nameUser').value = '';
    document.getElementById('emailBot').value = '';
    document.getElementById('message').value = '';
    $.ajax({

        url: 'messageSave?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(user),
        success: function (res) {

        }

    })
}
//-------------------------------------------------build message body -----------------------------------
function messageSaveBottom() {

    var user = {

        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        message: document.getElementById('message').value


    }

    document.getElementById('name').value = '';
    document.getElementById('email').value = '';
    document.getElementById('message').value = '';
    $.ajax({

        url: 'messageSave?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(user),
        success: function (res) {

        }

    })

}
//---------------------------------naholeru!?!?!?!??!?!? D: TREBA!---------------------
function wrapperSave() {

    var userWrapper = {

        name: document.getElementById('nameFormLeft').value,
        phoneOrEmail: document.getElementById('emailOfPhoneFormLeft').value,

    }

    document.getElementById('nameFormLeft').value = '';
    document.getElementById('emailOfPhoneFormLeft').value = '';

    $.ajax({

        url: 'messageCall?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(userWrapper),
        success: function (res) {

        }

    })

}
// _________________________________________________валідація для правої
// форми________start_________________________________
function validationEmailOfPhoneFormLeft() {

    var emailOfPhoneFormLeft = document.getElementById('emailOfPhoneFormLeft').value;
    var nameFormLeft = document.getElementById('nameFormLeft').value;
    var checkPhone = true;
    var checkPhoneOrPhone = true;
    for (var i = 0; i < emailOfPhoneFormLeft.length; i++) {
        if (checkPhoneOrPhone && emailOfPhoneFormLeft[i] != '@') {
            checkPhoneOrPhone = true;
        } else {
            checkPhoneOrPhone = false;
        }
    }
    if (checkPhoneOrPhone) {

        for (var i = 0; i < emailOfPhoneFormLeft.length; i++) {
            if (emailOfPhoneFormLeft[i] == '1' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '2' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '3' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '4' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '5' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '6' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '7' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '8' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '9' && checkPhone) {
                check = true;
            } else if (emailOfPhoneFormLeft[i] == '0' && checkPhone) {
                check = true;
            } else {
                check = false;
            }
        }
    }
    if (!checkPhoneOrPhone && nameFormLeft != "" && nameFormLeft.length < 255) {
        if (emailOfPhoneFormLeft.length < 255) {
            messageHOME();
            wrapperSave();
            document.getElementById('loggerFormLeft').innerHTML = "ready";
            document.getElementById('loggerFormLeft').style = "color:green;";
            document.getElementById("mySidenav").style.zIndex = "8";
            document.getElementById("mySidenav").style.width = "0px";
            document.getElementById("mySidenav").style.width = "40%";
            document.getElementById("mySidenav").style.left = "140%";
            document.getElementById("block-right-navslide").style.display = "none";
        } else {
            document.getElementById('loggerFormLeft').innerHTML = "error eMail length";
            document.getElementById('loggerFormLeft').style = "color:red;"
        }
    } else {

        if (checkPhone
            && (emailOfPhoneFormLeft.length == 10 || emailOfPhoneFormLeft.length == 12)
            && nameFormLeft != "") {
            messageHOME();
            wrapperSave();
            document.getElementById('loggerFormLeft').innerHTML = "ready";
            document.getElementById('loggerFormLeft').style = "color:green;";

        } else if (!(nameFormLeft.length < 255)) {
            document.getElementById('loggerFormLeft').style = "color:red;"
            document.getElementById('loggerFormLeft').innerHTML = "error name length";
        } else {
            if (nameFormLeft == "") {
                document.getElementById('loggerFormLeft').style = "color:red;"
                document.getElementById('loggerFormLeft').innerHTML = "name not found";
            } else {
                document.getElementById('loggerFormLeft').innerHTML = "Incorrect telephone number of eMail";
                document.getElementById('loggerFormLeft').style = "color:red;"

            }

        }
    }

    return false;
}
// _________________________________________________валідація для правої
// форми________end_________________________________

// _________________________________________________валідація для bottom
// форми________start_________________________________
function validationEmailOfPhoneFormBottom() {
    // nameUser-bottom email-bottom message-bottom
    var email = document.getElementById('email-bottom').value;
    var name = document.getElementById('nameUser-bottom').value;
    var message = document.getElementById('message-bottom').value;

    var checkEmail = true;
    for (var i = 0; i < email.length; i++) {
        if (checkEmail && email[i] != '@') {
            checkEmail = true;
        } else {
            checkEmail = false;
        }
    }
    if (!checkEmail && email != "" && email.length < 255) {

        if (name != "" && name.length < 255) {
            document.getElementById('loggerFormBottom').innerHTML = "";
            if (message != "" && message.length < 255) {
                document.getElementById('loggerFormBottom').style = "color:green;";
                document.getElementById('loggerFormBottom').innerHTML = "ready!";
                messageSaveBottom();
                messageHOME();
            } else {
                document.getElementById('loggerFormBottom').style = "color:red;";
                document.getElementById('loggerFormBottom').innerHTML = "not found message";
            }
        } else {
            document.getElementById('loggerFormBottom').style = "color:red;";
            document.getElementById('loggerFormBottom').innerHTML = "name not found";
        }

    } else {
        document.getElementById('loggerFormBottom').style = "color:red;";
        if (checkEmail) {
            document.getElementById('loggerFormBottom').innerHTML = "incorrectly eMail";
        } else {
            document.getElementById('loggerFormBottom').innerHTML = "eMail not found";
        }
    }

}

// _________________________________________________валідація для bottom
// форми________end_________________________________

// -=-=-=-=-=--=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--
// =======-=--------------=================--------====BUILD EMAIL
// OBJECT-=-=-==-=-=-=-===-==---=-

function emailObject() {
    var userInSelect = $("#userSelect").multipleSelect("getSelects");

    var massUsers = [];

    for (var i = 0; i < userInSelect.length; i++) {

        for (var j = 0; j < selectionsUser.length; j++) {

            if (userInSelect[i] == selectionsUser[j].email) {

                massUsers.push(selectionsUser[j]);

            }
        }

    }
    var now = new Date();
    var messagsss = document.getElementById('messageForEmail').value;
    var theme = document.getElementById("theme-email").value;
    var emailbody = document.getElementById("emailbodyinput").value;

    for (var i = 0; i < massUsers.length; i++) {

        var user = {

            email: massUsers[i].email,
            message: messagsss,
            name: theme,
            phone: emailbody

        }

        document.getElementById('messageForEmail').value = '';
        document.getElementById("theme-email").value = '';
        $.ajax({

            url: 'sendEmail?' + $('input[name=csrf_name]').val() + "="
            + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(user),
            success: function (res) {

            }

        })

    }

}
//==================================================== all users with messages ===============================
function loadUserSelect() {

    $.ajax({
        url: 'loadUserSelect?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {
            var all;
            selectionsUser = res;
            for (var i = 0; i < res.length; i++) {

                all += "<option value=" + res[i].email + ">" + res[i].email
                    + "</option>";

            }
            document.getElementById('userSelect').innerHTML = all;
            $("select").multipleSelect();
        }

    })

}
//======================================================delete file=============================
function deleteFile(index) {

    $
        .ajax({

            url: 'deleteFile?' + $('input[name=csrf_name]').val() + "="
            + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: '' + index,
            success: function (res) {

                var all = '';

                for (var i = 0; i < res.length; i++) {

                    all += "	<div style=\"color: black;\">";
                    all += "<div>";
                    all += "<div style=\"width: 30%; height: 50px; display: inline-block;\">";
                    all += "	<p>" + res[i].name + "</p>";
                    all += "	</div>";
                    all += "	<div style=\"width: 30%; height: 50px; display: inline-block;\">";
                    all += "	<p>download" + res[i].publicPath + ""
                        + res[i].id + "</p>";
                    all += "</div>"
                    all += "<a onclick=\"deleteFile('" + res[i].id + "')\"";
                    all += "	style=\"width: 30%; height: 50px; display: inline-block;\"";
                    all += "	href=\"#\">&times;</a>";
                    all += "</div>";
                    all += "</div>";

                }
                document.getElementById('fileContainer').innerHTML = all;

            }
        })

}
//===============================================----------------------------==========================
// window.onload = function () {
//     $.ajax({
//         url : 'loadGalleryForAdmin?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method : 'PUT',
//         contentType: 'application/json; charset=UTF-8',
//         dataType : 'json',
//         success : function (res) {
//
//             var all = '';
//
//             for(var i = 0; i < res.length; i++){
//                 var index = res[i].id;
//                 all +="<div><img class='div-image' src="+res[i].path+"><a class='div-image-close' href='#' onclick='deleteImg("+index+")'>&times;</a></div>"
//             }
//             document.getElementById('allGalleryImg').innerHTML = all;
//         }
//     })
//
// }
//-------------------------------------------------delete Img & game-------------------------
function deleteImg(index) {
    $.ajax({
        url: 'deleteImg?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {
            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += "<div class='div-container-image'><img class='div-image' src=" + res[i].path + "> <a class='div-image-close' href='#' onclick='deleteImg(" + index + ")'>&times;</a></div>"
            }
            document.getElementById('allGalleryImg').innerHTML = all;
        }
    })
    location.reload();
}
function deleteGame(index) {

    $.ajax({

        url: 'deleteGame?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'delete',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function () {

            location.reload();
        }
    })
    location.reload();
}
//------------------------------------------------------------- ---------------------
// +1 for state 
//
function messageHOME() {
    $.ajax({
        url: 'messageHOME?' + $('input[name=csrf_name]').val() + "="
        + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {

        }
    })
}