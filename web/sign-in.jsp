<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container">
    <div class="row mt-3 justify-content-center">
        <div class="col-6">
                <div class="row mt-2">
                    <h1 style="color: #0f5132"><%=user.getFullName()%></h1>
                </div>
        </div>
    </div>
</div>
</body>
</html>
