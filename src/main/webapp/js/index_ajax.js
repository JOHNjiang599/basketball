function soul() {
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
                if (data.user === "team") {
                    var UserName = data.user.name;
                    var Url = encodeURI("user.html?USERS=" + UserName);
                    window.location.href = Url;
                }
                else if (data.user === "caipan") {
                    var UserName = data.user.name;
                    var Url = encodeURI("user.html?USERS=" + UserName);
                    window.location.href = Url;
                }
            }
        }
    })
}