<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h1>用户注册</h1><br/>
<form method="post" action="${pageContext.request.contextPath}/user/addUser">
    <table class="regUser" border="1">
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
            <td><label>
                <input type="radio" name="userType" value="admin">
            </label>管理员
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="userType" value="team">
                </label>球队
            </td>
        </tr>
        <tr>
            <td><label>
                <input id="reg" type="submit" value="注册">
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
