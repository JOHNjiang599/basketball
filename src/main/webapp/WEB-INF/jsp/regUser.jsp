<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h1>用户注册</h1><br/>
<form method="post" action="${pageContext.request.contextPath}/basketball/addUser">
    <table class="regUser" border="1">
        <tr>
            <td>用户名:</td>
            <td>
                <input type="text" name="userName">
            </td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码:</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>类型:</td>
            <td>
                <input type="radio" name="userType" value="admin" checked="checked">管理员
                &nbsp;&nbsp;
                <input type="radio" name="userType" value="team">球队
            </td>
        </tr>
        <tr>
            <td><input id="reg" type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
