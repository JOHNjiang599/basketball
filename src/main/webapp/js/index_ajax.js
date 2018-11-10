function LogIn() {
    var radio = $('input[name="dataType"]:checked').val();
    $.ajax({
        type: "POST",
        url: "",
        async: "true",
        data: {
            dataType: radio,
            username: $("#username").val(),
            password: $("#password").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.msg === "1") {
                if (radio === "user") {
                    var UserName = data.user.name;
                    var Url = encodeURI("user.html?USERS=" + UserName);
                    window.location.href = Url;
                }
                else if (radio === "admin") {
                    var UserName = data.user.name;
                    var Url = encodeURI("user.html?USERS=" + UserName);
                    window.location.href = Url;
                }
            }
        }
    })
}

function Signin() {
    $.ajax({
        type: "POST",
        url: "",
        async: "true",
        data: {
            username: $("#username").val(),
            password: $("#password").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.msg === "1") {
                alert("注册成功，请登录");
                LogIn();
            }
        }
    })
}