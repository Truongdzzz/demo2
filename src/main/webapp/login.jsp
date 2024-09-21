<%--
  Created by IntelliJ IDEA.
  User: 84845
  Date: 9/16/2024
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %><%%>--%>
<html>
<h1>Welcome to my super website</h1>
<form action=login method="post">
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
                <input type="password" placeholder="Mật khẩu"
                       name="password"
                       class="form-control">
            </div>
            <button type="submit" style="width: 200px; height: 50px">Submit</button>
        </label>
        <a href="forgetpassword">Forget Password</a>
    </section>
<body>

</body>
</html>
