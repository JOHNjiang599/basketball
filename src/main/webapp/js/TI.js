var Url = window.location.href;
var Data = Url.split("=");
var Name = decodeURI(Data[1]);
divh = 300;
var TEAMID;


//从后台获取信息，把球队的信息填写到框框里面
$(function () {
    $.ajax({
        //与后台进行连接，接收json
        type: "post",
        url: '/team/gainmembers',
        async: true,
        dataType: "json",
        data: {
            "name": Name
        },
        success: function (result) {
            var m = "";//用于后续的append
            var mm = "";
            result = JSON.parse(result);
            $.each(result, function (i, n) {   //这里开始进行加
                /* console.log(n);//令控制台显示json，用来测试*/
                // m="<li>"+"姓名："+n["username"]+"密码："+n["password"]+"</li>";
                m = "<span>" + n.team.teamName + "<img src='' id='pls'>" + "</span>";
                TEAMID = n.team.teamId;
                $("#TeamName").append(m);
                $.each(n.memberList, function (index, comment) {
                    $("#TeamNumber tr").remove();
                    /*
                                        mm = "<tr>" + "<td>" + comment["memberFirstStart"] + "</td>" +
                                            "<td>" + comment["memberId"] + "</td>" +
                                            "<td>" + comment["memberName"] + "</td>" +
                                            "<td><button id='change' onclick='FUN'>编辑</button> " +
                                            "<button id='delete' onclick='Del'>删除</button> </td>" +
                                            "</tr>" + "<br>";
                    */
                    var id = index;
                    //表头
                    var os = "        <tr>\n" +
                        "            <td>是否首发</td>\n" +
                        "            <td>球衣号</td>\n" +
                        "            <td>球员姓名</td>\n" +
                        "            <td>操作</td>\n" +
                        "        </tr>";


                    //表格内容
                    mm += "<tr id='exc-";
                    mm += id;
                    mm += "' class='box'>";
                    mm += "<td>";
                    mm += comment["memberFirstStart"];
                    mm += "</td>";
                    mm += "<td>";
                    mm += comment["memberId"];
                    mm += "</td>";
                    mm += "<td>";
                    mm += comment["memberName"];
                    mm += "</td>";
                    mm += "<td><input type='button' id='change-" + id +
                        "' onclick='Change(this.id)' value='编辑'/>";
                    mm += "<input type='button' class='rosy' id='delete-" + id +
                        "' onclick='Del(this.id)'>删除</input></td>";
                    mm += "</tr>";
                    mm += "<br>";


                    $("#TeamNumber").append(os);
                    $("#TeamNumber").append(mm);
                    divh += 45;
                    $('.userdiv3').css({height: divh})
                })
            });
        }
    });
});

//当用户需要修改内容时，把修改过后的内容再通过json转交给后台
function Change(ID) {
    var a = $("#" + ID).parent();
    var b = a.siblings();
    b[0].innerHTML = "<input type='text' id='MF' value='" + b[0].innerText + "'/>";
    b[1].innerHTML = "<input type='text' id='MI' value='" + b[1].innerText + "'/>";
    b[2].innerHTML = "<input type='text' id='MN' value='" + b[2].innerText + "'/>";
    var c = a.innerText;
    console.log(c);
    a[0].innerHTML = "<input type='button' id='save' onclick='Save()' value='保存'>" +
        "<input type='button' id='cancel' onclick='Can()' value='取消'>";
}

function Del(ID) {
    var a = $("#" + ID).parent();
    var b = a.siblings();
    $.ajax({
        type: "POST",
        async: true,
        url: "/team/deletemember",
        dataType: "json",
        data: {
            "teamId": TEAMID,
            "memberId": b[1].innerText
        },
        success: function (result) {
            result = JSON.parse(result);
            if (result.status === true) {
                alert("删除成功");
                window.location.reload();
            }
            else {
                alert("删除失败，请重试");
                return false;
            }
        },
        error: function () {
            alert("服务器出错，请稍后再试");
            return false;
        }
    })
}


function Add() {
//    先进行表格的增加，然后把按钮变成保存和取消，之后进行input，之后在进行保存和取消的逻辑。但是取消用CAN()函数。是remove
    var newmember = "<tr><td><input type='text' id='MF'/></td>" +
        "<td><input type='text' id='MI'/></td>" +
        "<td><input type='text' id='MN'/></td>" +
        "<td><input type='button' id='save' onclick='SaveNew()' value='保存'>" +
        "<input type='button' id='cancel' onclick='Can()' value='取消'></td></tr>";
    $("#TeamNumber").append(newmember);
    divh += 45;
    $('.userdiv3').css({height: divh})//di
    /*    $.ajax({
            type:"POST",
            url:"",
            dataType:"json",
            async: true,
            data:{
                "memberFirstStart" : $("#MF").val(),
                "memberId":$("#MI").val(),
                "memberName":$("#MN").val(),
                "teamId":Name
            },
            success:function (result) {
                if (result.status === "1"){
                    window.location.reload();
                }
            },
            error:function () {
                alert("保存失败，请重试");
                return false;
            }
        })*/
}

function Save() {
    $.ajax({
        type: "POST",
        url: "/team/modifymember",
        async: true,
        dataType: "json",
        data: {
            "memberFirstStart": $("#MF").val(),
            "memberId": $("#MI").val(),
            "memberName": $("#MN").val(),
            "teamId": TEAMID
        },
        success: function (result) {
            result = JSON.parse(result);
            if (result.status === true) {
                alert("保存成功");
                window.location.reload();
            }
        },
        error: function () {
            alert("更改失败，请重试");
            return false;
        }
    })
}


function Can() {
    window.location.reload();
}

function SaveNew() {
    $.ajax({
        type: "POST",
        url: "/team/addmember",
        async: true,
        dataType: "json",
        data: {
            "memberFirstStart": $("#MF").val(),
            "memberId": $("#MI").val(),
            "memberName": $("#MN").val(),
            "teamId": TEAMID
        },
        success: function (result) {
            result = JSON.parse(result);
            if (result.status === true) {
                alert("添加成功");
                window.location.reload();
            }
        },
        error: function () {
            alert("更改失败，请重试");
            return false;
        }
    })
}
function GoBack() {
    window.location.href = "user.html";
}
function GoBack1() {
    window.location.href = "user.html";
}