<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Báo cáo kiểm thử</title>
</head>
<body>
    <h1>Báo cáo kiểm thử</h1>
    <p>Kết quả kiểm thử: <%= session.getAttribute("testResult") %></p>
    <p>Thời gian thực thi: <%= session.getAttribute("executionTime") %></p>
    <p>Tên người dùng đăng nhập: <%= session.getAttribute("loggedInAdminName") %></p>
    <p>Email người dùng đăng nhập: <%= session.getAttribute("loggedInAdminEmail") %></p>
</body>
</html>
