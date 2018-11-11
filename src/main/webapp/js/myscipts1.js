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


/*刷新队伍信息*/
/*function refresh(){

	var selected = document.getElementById("ResourceType").value;
    var m="";

    $.ajax({
        url:"/match/getmembers",
        type: "POST",
        async:true,
        data:{
            "teamId": selected
        },
        dataType:"json",
        success:function(result){
            var rs = JSON.parse(result);
            $.each(rs.members,function(i,node){
                m = "<span>"+node['memberName']+"</span>";
                $("#message1").append(m);
                // document.getElementById("message1").innerHTML+=node['memberName'];
            })
        }
    });
}*/


/*var selected = $("#test").val();*/

/*

function refresh(obj){
    var selected = obj.options[obj.selectedIndex].value;
    $.ajax({
        url:'/match/getmembers',
        type:"POST",
        data:{
            "teamId":selected
        },
        dataType:"json",
        success:function(result){
            result=JSON.parse(result);
            var n1,n2=0;
            $.each(result,function(i,node){
                if (node.memberFirstStart===1){
                    document.getElementById("message1").innnerHtml+=' '+node.memberName+' ';
                    n1+=1;
                    if((n1+=1) ===3){
                        document.getElementById("message1").innnerHtml+="<br>";
                            n1=0;
                    }
                }
                else{
                    document.getElementById("message2").innnerHtml+=' '+node.memberName+' ';
                    n2+=1;
                    if ((n2+=1)===3 ){
                        document.getElementById("message2").innnerHtml+="<br>";
                        n2=0;
                    }
                }

            });
        }
    });
}
*/
