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

            <% if(user!=null) {%>

            <button type="button" class="btn btn-success btn-sm mt-3 mb-3" data-bs-toggle="modal" data-bs-target="#addNews">
                + ADD NEWS
            </button>


            <div class="modal fade" id="addNews" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">ADD NEWS</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="/add-news">
                                <input type="hidden" name="user_id"   value="<%=user.getId()%>">
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
                                    <button type="submit" class="btn btn-success btn-sm">ADD NEWS</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <%
                }
            %>

            <%
                ArrayList<News> newsList = (ArrayList<News>) request.getAttribute("news");
                for (News news : newsList) {
            %>

            <div class="mt-2 border border-black border-2">
                <a class="text-decoration-none text-warning" href="/details-news?id=<%=news.getId()%>"><h1><%=news.getTitle()%></h1></a>
                <p class="mt-2"><%=news.getContent()%></p>
                <p> CREATED BY <%=news.getUser().getFullName()%> ON <%=news.getDate()%></p>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
