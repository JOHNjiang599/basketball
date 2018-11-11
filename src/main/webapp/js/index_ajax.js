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

    var userName = $("#username").val();//获取用户名
    var password = $("#password").val();//获取用户密码
    var userType = $("input[type='radio']:checked").val();//获取单选框的值

    var success = checkLogin(userName, password);

    if (success === true) {
        $.ajax({
            url: "/user/login",
            type: "POST",
            data: {
                "userName": userName,
                "password": password,
                "userType": userType
            },
            dataType: "json",//预期服务器返回类型
            success: function (result) {
                var rs = JSON.parse(result);
                if (rs.msg.status === true) {
                    if (rs.msg.userType === "user") {
                        if (userType === "user") {
                            var Url = encodeURI("start/user.html?user=" + rs.msg.username);
                            window.location.href = Url;
                        }
                        else {
                            alert("请选择相应账户进行登录")
                        }
                    }
                    if (rs.msg.userType === "referee") {
                        if (userType === "referee") {
                            var Url = encodeURI("start/referee.html?user=" + rs.msg.username);
                            window.location.href = Url;
                        }
                        else {
                            alert("请选择相应账户进行登录")
                        }

                    }
                } else {
                    alert("woshinibaba");
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

    var userName = $("#username-s").val();//获取用户名
    var password = $("#password-s").val();//获取用户密码
    var repassword = $("#repassword").val();//获取再输密码

    var isSuccess = checkReg(userName, password, repassword);

    if (isSuccess === true) {
        $.ajax({
            url: "/user/register",
            type: "POST",
            data: {
                "userName": userName,
                "password": password,
                "repassword": repassword
            },
            dataType: "json",//预期服务器返回类型
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