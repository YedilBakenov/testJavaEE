<%@ page import="model.Item" %>
<%@ page import="model.City" %>
<%@ page import="java.util.ArrayList" %>
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
            <%
                Item item =(Item)request.getAttribute("obj");
            %>
            <form method="post" action="/update-item">

                <input type="hidden" name="id" value="<%=item.getId()%>">

                <div class="row mt-2">
                    <div class="col-12">
                        <label>MODEL:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" name="model" class="form-control" value="<%=item.getModel()%>">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>DESCRIPTION:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea class="form-control" rows="5" cols="10" name="description"><%=item.getDescription()%></textarea>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>PRICE:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="number" name="price" class="form-control" value="<%=item.getPrice()%>">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>CITY:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-control" name="city_id">
                            <%
                                ArrayList<City> cities =(ArrayList<City>)request.getAttribute("goroda");
                                for(City c: cities){
                            %>
                            <option value="<%=c.getId()%>"><%=c.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success btn-sm">UPDATE ITEM</button>
                    </div>
                </div>
            </form>
            <form action="/delete-item" method="post">
                <input type="hidden" name="id" value="<%=item.getId()%>">
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-danger btn-sm">DELETE ITEM</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
