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
            <form method="post" action="/login">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>EMAIL:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" name="email" class="form-control">
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

                <div class="d-flex">
                    <div class="row mt-2">
                        <div class="col-12">
                            <button type="submit" class="btn btn-success btn-sm">SIGN IN</button>
                        </div>
                    </div>

                    <div class="row mt-2 ms-1">
                        <div class="col-12">
                            <a type="button" class="btn btn-primary btn-sm" href="/registration">SIGN UP</a>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
