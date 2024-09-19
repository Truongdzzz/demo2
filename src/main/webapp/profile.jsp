<%--
  Created by IntelliJ IDEA.
  User: 84845
  Date: 9/18/2024
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome ${sessionScope.username}</h1>
    <form action=logout method="get">
        <button type="submit">LOGOUT</button>
    </form>
</body>
</html>
