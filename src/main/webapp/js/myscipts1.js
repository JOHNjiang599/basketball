// JavaScript Document
/*进入缓存select信息*/
$.ajax({
    type: "GET",
    url: '/team/getteams',
    async: true,
    data: {},//请求数据，无参请求可不填
    /*contentType:"application/json",*///不要填这个
    dataType: "json",//预期服务器返回数据类型一定要加
    success: function (result) {
        var rs = JSON.parse(result);
        $.each(rs['teamList'], function (index, node) {
            /*console.log(node);
            console.log(node['teamId']);
            console.log(node['teamName']);*/
            document.getElementById("ResourceType1").options.add(new Option(node['teamName'], node['teamId']));
            document.getElementById("ResourceType2").options.add(new Option(node['teamName'], node['teamId']));
        })
    }
});


function GoHome() {
    var teamA = $("#ResourceType1").val();
    var teamB = $("#ResourceType2").val();
    var Url = "game.html?TeamA=" + teamA + "&TeamB=" + teamB;
    Url = encodeURI(Url);
    window.location.href = Url;
}