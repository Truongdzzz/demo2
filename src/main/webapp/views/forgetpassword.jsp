<%--
  Created by IntelliJ IDEA.
  User: 84845
  Date: 9/21/2024
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=forgetpassword method="post">
  <h2>Đăng nhập</h2>
  <c:if test="${alert !=null}">
  <h3 class="alert alertdanger" style="color: red">${alert}</h3>
  </c:if>
  <section>
    <label class="input login-input">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fauser"></i></span>
        <input type="text" placeholder="Tài khoản"
               name="username"
               class="form-control">
        <input type="password" placeholder="Mật khẩu cũ"
               name="password"
               class="form-control">
        <input type="password" placeholder="Mật khẩu mới"
               name="newPassword"
               class="form-control">
      </div>
      <button type="submit" style="width: 200px; height: 50px">Submit</button>
    </label>
  </section>
</body>
</html>
