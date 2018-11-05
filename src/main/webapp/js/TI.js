//从后台获取信息，把球队的信息填写到框框里面
function TeamI() {
    $.ajax({
        //与后台进行连接，接收json
        type: "get",
        url: "nonono",
        async: true,
        success: function (result) {
            var m = "";//用于后续的append
            var mm = "";
            result = JSON.parse(result);
            $.each(result.teams, function (i, n) {   //这里开始进行加
                /* console.log(n);//令控制台显示json，用来测试*/
                // m="<li>"+"姓名："+n["username"]+"密码："+n["password"]+"</li>";
                m = "<span>" + n["teamName"] + "<img src='' id='pls'>" + "</span>";
                console.log(m);
                $("#TeamName").append(m);
                $.each(n.memberList, function (index, comment) {
                    mm = "<tr>" + "<td>" + comment["memberFirstStart"] + "</td>" +
                        "<td>" + comment["memberId"] + "</td>" +
                        "<td>" + comment["memberName"] + "</td>" +
                        "<td><button id='change' onclick='FUN'>编辑</button> " +
                        "<button id='delete' onclick='DEL'>删除</button> </td>" +
                        "</tr>" + "<br>";
                    console.log(mm);
                    $("#TeamNumber").append(mm);
                })
            });
        }
    });
}

//当用户需要修改内容时，把修改过后的内容再通过json转交给后台
function change() {

}