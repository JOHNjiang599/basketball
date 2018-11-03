<%--
  Created by IntelliJ IDEA.
  User: weixingfu
  Date: 2018/10/23
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<body>
<!--修改一下，要把这一部分改成表单请求。把这一部分内容改成表单和发请求的。-->
<input type="button" formaction="TeamIn" value="历史记录">
<button class="his" onclick="window.location.href='history_test.html'">历史记录</button>
<br/>
<br><br><br>
<button class="vs">对战选择</button>

</body>
</html>