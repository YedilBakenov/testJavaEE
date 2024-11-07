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
            <form method="post" action="/registration">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>EMAIL:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" name="email" class="form-control" required>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>FULL NAME:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" name="full_name" class="form-control">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>PASSWORD:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" name="password" class="form-control">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>REPEAT PASSWORD:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" name="re_password" class="form-control">
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success btn-sm">REGISTRATION</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
