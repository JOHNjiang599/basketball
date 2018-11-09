//从后台获取信息，把球队的信息填写到框框里面
$(function TeamI() {
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
                    mm += "<button type='button' class='rosy' id='delete-" + id +
                        "' onclick='Del(this.id)'>删除</button></td>";
                    mm += "</tr>";
                    mm += "<br>";


                    $("#TeamNumber").append(os);
                    $("#TeamNumber").append(mm);
                })
            });
        }
    });
});

//当用户需要修改内容时，把修改过后的内容再通过json转交给后台
function Change(ID) {
    var a = $("#" + ID).parent();
    var b = a.siblings();
    b[0].innerHTML = "<input type='text' value='" + b[0].innerText + "'/>";
    b[1].innerHTML = "<input type='text' value='" + b[1].innerText + "'/>";
    b[2].innerHTML = "<input type='text' value='" + b[2].innerText + "'/>";
    var c = a.innerText;
    console.log(c);
    a.innerHTML = "<input type='button' id='save' onclick='Save()' value='保存'>" +
        "<input type='button' id='cancel' onclick='Can()' value='取消'>";
}

function Del(ID) {
    var a = $("#" + ID).parent();
    var b = a.siblings();
    var member = {memberId: b[1].innerText};
    $.ajax({
        type: "POST",
        data: $.param(member),
        url: "",
        dataType: "json",
        success: function (result) {
            if (result.status === "1") {
                alert("删除成功");
                window.location.reload();
            }
            else {
                alert("删除失败，请重试");
                ;
                return false;
            }
        }
    })
}


function Add() {

}

function Save() {

}

function Can() {

}