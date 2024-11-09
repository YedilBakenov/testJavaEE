<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Item" %>
<%@ page import="model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container mt-3">
    <form action="/main" method="get">
        <div class="d-flex mb-2">
            <input type="text" name="word" class="form-control" style="width: 90%;">
            <button class="btn btn-success btn-sm ms-2">SEARCH</button>
        </div>
    </form>


    <% if (user != null && user.getRole() == 2) {%>

    <button type="button" class="btn btn-success btn-sm mt-3 mb-3" data-bs-toggle="modal" data-bs-target="#addItem">
        + ADD ITEM
    </button>

    <%
        }
    %>

    <div class="modal fade" id="addItem" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">ADD ITEM</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
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
                                <label>CITY:</label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <select class="form-control" name="city_id">
                                    <%
                                        ArrayList<City> cities = (ArrayList<City>) request.getAttribute("goroda");
                                        for (City c : cities) {
                                    %>
                                    <option value="<%=c.getId()%>"><%=c.getName()%>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Close
                            </button>
                            <button type="submit" class="btn btn-success btn-sm">ADD ITEM</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>ID</th>
            <th>MODEL</th>
            <th>DESCRIPTION</th>
            <th>PRICE</th>
            <th>CITY</th>
            <th>DETAILS</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("spisok");
            for (Item it : items) {
        %>
        <tr>
            <td><%=it.getId()%>
            </td>
            <td><%=it.getModel()%>
            </td>
            <td><%=it.getDescription()%>
            </td>
            <td><%=it.getPrice()%>
            </td>
            <td><%=it.getCity().getName()%>/<%=it.getCity().getCode()%>
            </td>
            <td style="width: 8%"><a class="btn btn-sm btn-secondary"
                                     href="/item-details?id=<%=it.getId()%>">DETAILS</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
