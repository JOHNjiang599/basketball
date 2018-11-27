function checkLogin(userName, password) {

    if (userName.trim() === "") {
        alert("请输入用户名");
        return false;
    }
    if (password.trim() === "") {
        alert("请输入密码");
        return false;
    }
    return true;
}

function login() {

    var userName = $("#username").val();
    var password = $("#password").val();
    var userType = $("input[type='radio']:checked").val();

    var success = checkLogin(userName, password);
    if (success === true) {
        $.ajax({
            url: "/user/login",
            type: "POST",
            dataType: "json",
            async: true,
            data: {
                "userName": userName,
                "password": password,
                "userType": userType
            },
            success: function (result) {
                var rs = JSON.parse(result);
                if (rs['msg']['status'] === true) {
                    if (rs['msg']['userType'] === "user") {
                        if (userType === "user") {
                            var Url = encodeURI("/start/user.html?user=" + rs['msg']['username']);
                            window.location.href = Url;
                        }
                        else {
                            alert("请选择相应账户进行登录")
                        }
                    }
                    if (rs['msg']['userType'] === "referee") {
                        if (userType === "referee") {
                            var Url = encodeURI("/start/referee.html?user=" + rs['msg']['username']);
                            window.location.href = Url;
                        }
                        else {
                            alert("请选择相应账户进行登录")
                        }

                    }
                } else {
                    alert("");
                }

            },
        });
    }
}

function checkReg(userName, password, repassword) {

    if (userName.trim() === "") {
        alert("请输入用户名");
        return false;
    }
    if (password.trim() === "") {
        alert("请输入密码");
        return false;
    }
    if (password.length > 15 || password.length < 6) {
        alert("请输入大于6位小于15位的密码");
        return false;
    }
    if (repassword.trim() === "") {
        alert("请重复之前的密码");
        return false;
    }
    if (password !== repassword) {
        alert("请输入相同的密码");
        return false;
    }
    return true;
}

function register() {

    var userName = $("#username-s").val();
    var password = $("#password-s").val();
    var repassword = $("#repassword").val();

    var isSuccess = checkReg(userName, password, repassword);

    if (isSuccess === true) {
        $.ajax({
            url: "/user/register",
            type: "POST",
            async: true,
            dataType: "json",
            data: {
                "userName": userName,
                "password": password,
                "repassword": repassword
            },
            success: function (result) {
                var rs = JSON.parse(result);
                if (rs['msg']['status'] === true) {
                    alert("注册成功")
                }
                if (rs['msg']['status'] === false) {
                    alert("注册失败")
                }
            },
        });
    }
}