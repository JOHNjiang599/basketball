/*读取当前用户的用户名or球队编号均可*/
$(function () {
    var Url = window.location.href;
    var Data = Url.split("=");
    var Name = decodeURI(Data[1]);
    $("#Name").append(Name);
});
/*******************************************************/