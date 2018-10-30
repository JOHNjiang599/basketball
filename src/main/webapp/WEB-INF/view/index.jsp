<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <<<<<<< HEAD:src/main/webapp/test/index_test.html
    <title>Title</title>
    <script type="text/javascript" src="../../js/index_js.js"></script>
    =======
    <title>阿布斯特朗回旋加速阿姆斯特朗篮球对战平台</title>
    <link rel="stylesheet" type="text/css" href="../../css/index_css.css">
    <script type="text/javascript" src="../../js/index_js.js"></script>
    >>>>>>> remotes/origin/dev-JOHN:src/main/webapp/WEB-INF/jsp/index.html
</head>
<body onload="show()">

<!--登陆页面，登陆和注册时在一起的，登陆时隐藏注册，注册时隐藏登陆-->
<div id="login">
    <form class="login" action="${pageContext.request.contextPath}/user/validateUser">
        <label>
            <input type="radio" name="identification" value="user" checked>
        </label>球队用户
        <label>
            <input type="radio" name="identification" value="admin">
        </label>管理员<br><br>
        用户名:<br>
        <label>
            <input type="text" name="username">
            <<<<<<< HEAD:src/main/webapp/test/index_test.html
        </label><br>
        密码：<br>
        <label>
            <input type="password" name="password">
            =======
        </label>
        <br>
        密码：<br>
        <label>
            <input type="password" name="password" placeholder="PASSWORD">
            >>>>>>> remotes/origin/dev-JOHN:src/main/webapp/WEB-INF/jsp/index.html
        </label>
        <br><br>
        <input type="submit" value="登陆">
    </form>
    <button class="regist" onclick="Regist()">注册账户(球队专用）</button>
</div>


<!--注册框，添加一个框框的颜色，margin和padding-->
<div class="register" id="logup">
    <form action="${pageContext.request.contextPath}/user/addUser">
        用户名：<br>
        <label>
            <input type="text" name="username">
        </label>
        <br>
        密码：<br>
        <label>
            <input type="password" name="password">
        </label>
        <br>
        重复输入密码：<br>
        <label>
            <input type="password" name="repassword">
        </label>
        <br>
        <input type="submit" value="注册账号">
    </form>
    <button id="log" onclick="Login()">返回登陆</button>
</div>
</body>
</html>

