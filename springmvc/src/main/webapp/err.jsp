<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常页面</title>
</head>
<body>
<h1>出现异常，这是一张500页面</h1>
<br>
<%-- 打印异常到页面上 --%>
<% Exception ex = (Exception)request.getAttribute("ex"); %>
<br>
<div><%=ex.getMessage()%></div>
<% ex.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>