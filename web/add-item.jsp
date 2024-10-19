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
            <form method="post" action="/add-item">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>MODEL:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" name="model" class="form-control">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>DESCRIPTION:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea class="form-control" rows="5" cols="10" name="description"></textarea>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>PRICE:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="number" name="price" class="form-control">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success btn-sm">ADD ITEM</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
