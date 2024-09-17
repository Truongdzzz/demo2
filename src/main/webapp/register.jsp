<%--
  Created by IntelliJ IDEA.
  User: 84845
  Date: 9/17/2024
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=register method="post">
<h2>Tạo tài khoản mới</h2>
<c:if test="${alert !=null}">
  <h3 class="alert alertdanger">${alert}</h3>
</c:if>
<section>
  <label class="input login-input">
    <div class="input-group">
      <span class="input-group-addon"><i class="fa fauser"></i></span>
      <input type="text" placeholder="Tài khoản"
             name="username"
             class="form-control">
      <input type="password" placeholder="Mật khẩu"
             name="password"
             class="form-control">
      <input type="text" placeholder="email"
             name="email"
             class="form-control">
      <input type="text" placeholder="phone"
             name="phone"
             class="form-control">
    </div>
    <button type="submit" style="width: 200px; height: 50px">Đăng ký</button>
  </label>
</section>
</body>
</html>
