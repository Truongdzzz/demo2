<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/commons/web/header.jsp"%>
<sitemesh:write property="body"/>
<%@include file="/commons/web/footer.jsp"%>
</body>
</html>
