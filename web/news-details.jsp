<%@ page import="java.util.ArrayList" %>
<%@ page import="model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container">
    <div class="row mt-3">


        <div class="col-12">
            <%
                News news = (News) request.getAttribute("news");
            %>

                <div class="mt-2 border border-black border-2">
                    <a class="text-decoration-none text-warning"><h1><%=news.getTitle()%></h1></a>
                    <p class="mt-2"><%=news.getContent()%></p>
                    <p> CREATED BY <%=news.getUser().getFullName()%> ON <%=news.getDate()%></p>
                </div>

            <% if(user!=null && news.getUser().getId()==user.getId()) {%>

            <button type="button" class="btn btn-success btn-sm mt-3 mb-3" data-bs-toggle="modal" data-bs-target="#addNews">
                 UPDATE NEWS
            </button>
            <div class="modal fade" id="addNews" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">UPDATE NEWS</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="/update-news">
                                <input type="hidden" name="id" value="<%=news.getId()%>">
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <label>TITLE:</label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" name="title" class="form-control">
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <label>CONTENT:</label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <textarea class="form-control" rows="5" cols="10" name="content"></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-success btn-sm">UPDATE NEWS</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <form action="/delete-news" method="post">
                <input type="hidden" name="id" value="<%=news.getId()%>">
                <button class="btn btn-sm btn-danger">DELETE NEWS</button>
            </form>

            <% }%>

        </div>


    </div>
</div>
</body>
</html>
