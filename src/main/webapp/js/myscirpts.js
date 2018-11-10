var intervalId;
var i = 2;
var ttime = 2 * 60;//总时间
var count = ttime;//当前时间
var total = 4;//总节数
var ttotal = 1;//当前节数
var s = 0;//qiudui
var x = 0;//球衣
var y;//操作
var z;//换人操作
var grade_1 = 0, grade_2 = 0;//fenshu;
var a1 = new Array("21", "22", "03", "04", "05");
var b1 = new Array("51", "12", "14", "04", "05");
var a2 = new Array("10", "12", "13", "14", "15");
var b2 = new Array("13", "16", "23", "49", "30");
var cao = 1;
$.ajax({
    type: 'POST',
    url: '/match/getmembers',
    data: cao,
    success: function (result) {
        result = JSON.parse(result);
        n = 0;
        $.each(result.first, function (i, n1) {
            console.log(n1.memberId);
            a1[n] = n1.memberId;
            n += 1;
        })
    }
});

function ajaxList() {
    var myList = new Array('hello', 'ajax');
    var myMap = {
        'a': '1',
        'b': '2'
    };
    $.ajax({
        type: "post",
        url: "ajax/List",
        contentType: 'application/json;charset=UTF-8',	//发送信息至服务器时内容编码类型
        traditional: true,	//传统的方式来序列化数据
        data: JSON.stringify({uid: 233, myList: myList, myMap: myMap}),
        success: function (data) {
            alert("success");
        }
    });
}

/*window.onload=function(){
	for(i=1;i<6;i++){
		document.getElementById(i).innerHTML=a1[i-1];
		document.getElementById(i+100).innerHTML=b1[i-1];
		document.getElementById(i+200).innerHTML=a2[i-1];
		document.getElementById(i+300).innerHTML=b2[i-1];
	}
	
};*/


function btn1(val) {
    y = val;
    val = parseInt(val);
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
    if (s == 0)
        document.getElementById('changenav').style.display = 'block';
    else
        document.getElementById('changenav2').style.display = 'block';
}

function plus(val) {
    val = parseInt(val);
    if (s == 0) {
        grade_1 += val;
        if (grade_1 < 10)
            document.getElementById("grade_1").innerHTML = '0' + grade_1;
        else
        // document.getElementById("grade_1").innerHTML=grade_1;
            $("grade_1").append(grade_1);
    }
    if (s == 1) {
        grade_2 += val;
        if (grade_2 < 10)
            document.getElementById("grade_2").innerHTML = '0' + grade_2;
        else
            document.getElementById("grade_2").innerHTML = grade_2;

    }

}

function change(val) {
    var s1, s2;
    var p1, p2;
    node = s * 100 + x;
    val = parseInt(val);
    p1 = document.getElementById(node);
    p2 = document.getElementById(val);
    z = p2;
    s1 = p1.innerHTML;
    s2 = p2.innerHTML;
    p1.innerHTML = s2;
    p2.innerHTML = s1;
}

function startTime() {
    var minute = document.getElementById("minute");
    var second = document.getElementById("second");
    var buttonEle = document.getElementById("start");
    switch (i) {
        case 0:
            intervalId = setInterval("counttime()", 1000);
            i = 1;
            break;
        case 1:
            clearInterval(intervalId);
            i = 0;
            break;
        case 2:
            count = ttime;
            i = 0;
    }
}

function counttime() {
    var theminute = parseInt(count / 60);
    var thesecond = parseInt(count % 60);
    if (count > 0) {
        count -= 1;

    }
    else {
        ttotal++;
        i = 2;
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
