var intervalId;
var ttime = 12 * 60;//总时间
var count = ttime;//当前时间
var total = 4;//总节数
var ttotal = 1;//当前节数
var s = 0;//qiudui
var x = 0;//球衣
var m_id;
var y;//操作
var z = 0;//换人操作
var grade_1 = 0, grade_2 = 0;//fenshu;
var a1 = new Array(5);
var b1 = new Array(5);
var a2 = new Array(5);
var b2 = new Array(5);
var team = new Array(2);
var minute;
var second;
var buttonEle;
var chose = 2;
var break1 = 0;//a队犯规
var break2 = 0;//b队犯规
var breaka = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
var breakb = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//获取双方队伍id
var Url = window.location.href;
var Data = Url.split("=");
var cao = Data[1].split("&");
var teamA = cao[0];
var teamB = Data[2];

$.ajax({
    type: "POST",
    url: '/match/getteamfirst',
    async: true,
    data: {
        "teamIdA": teamA,
        "teamIdB": teamB
    },
    dataType: 'json',
    success: function (result) {
        var rs = JSON.parse(result);
        $.each(rs, function (idx, data) {
            n1 = 0;
            n2 = 0;
            $.each(data.firstTeam, function (index, node) {
                if (node.memberFirstStart === 1) {
                    a1[n1] = node.memberId;
                    n1 += 1;
                }
                else {
                    a2[n2] = node.memberId;
                    n2 += 1;
                }
            });
            n1 = 0;
            n2 = 0;
            $.each(data.secTeam, function (index, node) {
                if (node.memberFirstStart === 1) {
                    b1[n1] = node.memberId;
                    n1 += 1;
                }
                else {
                    b2[n2] = node.memberId;
                    n2 += 1;
                }

            });

        });

        for (i = 1; i < 6; i++) {
            document.getElementById(i).innerHTML = a1[i - 1];
            document.getElementById(i + 100).innerHTML = b1[i - 1];
            document.getElementById(i + 200).innerHTML = a2[i - 1];
            document.getElementById(i + 300).innerHTML = b2[i - 1];
        }
    },
});


function ajaxList() {
    matchminute = parseInt(count / 60);
    matchsecond = parseInt(count % 60);
    moment = matchminute.toString() + ":" + matchsecond.toString();

    if (s === 0)
        s = teamA;
    else
        s = teamB;

    $.ajax({
        type: "post",
        url: "/match/addmatch",
        async: true,
        data: {
            "matchSection": ttotal,
            "matchTime": moment,
            "eventType": y,
            "memberId": m_id,
            "teamId": s,
        },
        dataType: "json",
        success: function (result) {
            var rs = JSON.parse(result);
            //TODO:判别犯规次数；
        }
    });
}

function btn1(val) {
    val = parseInt(val);
    m_id = parseInt(x = document.getElementById(val).innerHTML);
    s = 0;
    if (val > 100) {
        s = 1;
        val -= 100;
    }
    x = val;
    document.getElementById('tablenav').style.display = 'block';
}

function btn2() {
    document.getElementById('tablenav').style.display = 'none';
    document.getElementById('changenav').style.display = 'none';
    document.getElementById("changenav2").style.display = 'none';

}

function btn3() {
    if (s === 0)
        document.getElementById('changenav').style.display = 'block';
    else
        document.getElementById('changenav2').style.display = 'block';
}

/*加分*/
function plus(val) {
    val = parseInt(val);
    y = val;
    if (s === 0) {
        grade_1 += val;
        if (grade_1 < 10)
            document.getElementById("grade_1").innerHTML = '0' + grade_1;
        else
        // document.getElementById("grade_1").innerHTML=grade_1;
            document.getElementById("grade_1").innerHTML = grade_1;
    }
    if (s === 1) {
        grade_2 += val;
        if (grade_2 < 10)
            document.getElementById("grade_2").innerHTML = '0' + grade_2;
        else
            document.getElementById("grade_2").innerHTML = grade_2;

    }
    if (val === 0) {
        if (s === 0) {
            break1 += 1;
            breaka[x] += 1;

            if ((breaka[x] % 4) == 0)
                alert("该球员四犯");
            if ((breaka[x] % 5) == 0)
                alert("该球员五犯");
            if ((break1 % 7) == 0)
                alert("a队7犯")
            if ((break1 % 8) == 0)
                alert("a队罚球");

        }
        if (s === 1) {
            break2 += 1;
            breakb[x] += 1;
            if ((breakb[x] % 4) == 0)
                alert("该球员四犯");
            if ((breakb[x] % 5) == 0)
                alert("该球员五犯");
            if ((break2 % 7) == 0)
                alert("b队7犯")
            if ((break2 % 8) == 0)
                alert("b队罚球")
        }


    }
    ajaxList();

}

/*换人*/
function change(val) {
    var s1, s2;
    var p1, p2;
    var x2;
    var temp;
    node = s * 100 + x;
    val = parseInt(val);
    x2 = val % 100;
    if (s === 0) {
        temp = breaka[x];
        breaka[x] = breaka[x2];
        breaka[x2] = temp
    }
    if (s === 1) {
        temp = breakb[x];
        breakb[x] = breakb[x2];
        breakb[x2] = temp;

    }
    p1 = document.getElementById(node);
    p2 = document.getElementById(val);
    s1 = p1.innerHTML;
    s2 = p2.innerHTML;
    p1.innerHTML = s2;
    p2.innerHTML = s1;
}

/*倒计时*/
function startTime() {
    minute = document.getElementById("minute");
    second = document.getElementById("second");
    buttonEle = document.getElementById("start");
    switch (chose) {
        case 0:
            intervalId = setInterval("counttime()", 1000);
            chose = 1;
            break;
        case 1:
            clearInterval(intervalId);
            chose = 0;
            break;
        case 2:
            count = ttime;
            chose = 0;
    }
}

var theminute;
var thesecond;
/*倒计时*/
function counttime() {
    theminute = parseInt(count / 60);
    thesecond = parseInt(count % 60);
    if (count > 0) {
        count -= 1;

    }
    else {
        ttotal++;
        chose = 2;
        clearInterval(intervalId);
    }
    if (theminute >= 10)
        minute.innerHTML = theminute;
    else
        minute.innerHTML = "0" + theminute;
    if (thesecond >= 10)
        second.innerHTML = thesecond;
    else
        second.innerHTML = "0" + thesecond;
}

function GoBack() {
    window.location.href = "xuanren.html";
}

