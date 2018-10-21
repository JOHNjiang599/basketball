<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/basketball/validateUser">
    <table class="showLogin" border="1">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="radio" name="userType" value="管理员" checked="checked">管理员</td>
            <td><input type="radio" name="userType" value="球队">球队</td>
        </tr>
    </table>
    <input id="login" type="submit" value="登录">
</form>
</body>
</html>
