<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/validateUser">
    <table class="showLogin" border="1">
        <tr>
            <td>用户名:</td>
            <td><label>
                <input type="text" name="userName">
            </label></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码:</td>
            <td><label>
                <input type="password" name="password">
            </label></td>
        </tr>
        <tr>
            <td>类型:</td>
            <td>
                <label>
                    <input type="radio" name="userType" value="admin" checked="checked">
                </label>管理员
                <label>
                    <input type="radio" name="userType" value="team">
                </label>球队
            </td>
        </tr>
    </table>
    <input id="login" type="submit" value="登录">
</form>
</body>
</html>
