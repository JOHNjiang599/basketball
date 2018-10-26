function show() {
    document.getElementById("logup").style.display = "none";

    document.getElementById("login").style.display = "block";
}

function Login() {
    document.getElementById("logup").style.display = "none";

    document.getElementById("login").style.display = "block";

}

function Regist() {
    document.getElementById("logup").style.display = "block";

    document.getElementById("login").style.display = "none";
}

//登陆的验证逻辑
/**
 * @return {boolean}
 */
function GoLogin() {
    if ($("#username").val().trim() === "") {
        alert("请输入用户名");
        return false;
    }
    if ($("#password").val().trim() === "") {
        alert("请输入密码");
        return false;
    }
    return true;
}

//注册的验证逻辑
/**
 * @return {boolean}
 */
function GoSignUP() {
    if ($("#username-s").val().trim() === "") {
        alert("请输入用户名");
        return false;
    }
    if ($("#password-s").val().trim() === "") {
        alert("请输入密码");
        return false;
    }
    if ($("#password-s").val().length > 15 || $("#password-s").val().length < 6) {
        alert("请输入大于6位小于15位的密码");
        return false;
    }
    if ($("#repassword").val().trim() === "") {
        alert("请重复之前的密码");
        return false;
    }
    if ($("#password-s").val() !== $("#repassword").val()) {
        alert("请输入相同的密码");
        return false;
    }
    return true;

}