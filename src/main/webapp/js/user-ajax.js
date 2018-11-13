/*读取当前用户的用户名or球队编号均可*/
$(function () {
    var Url = window.location.href;
    var Data = Url.split("=");
    var Name = decodeURI(Data[1]);
    $("#Name").append(Name);
})


/*******************************************************/

//到球队信息页面的跳转
function mes() {
    var Url = window.location.href;
    var Data = Url.split("=");
    var Url = encodeURI("teamInfo.html?USERS=" + Data[1]);
    window.location.href = Url;
}

/*******************************************************/

//到历史对战页面的跳转
function his() {
    var Url = window.location.href;
    var Data = Url.split("=");
    var Url = encodeURI("history.html?USERS=" + Data[1]);
    window.location.href = Url;
}