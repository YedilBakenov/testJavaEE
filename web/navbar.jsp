<%@ page import="model.User" %>
<% User user = (User) request.getSession().getAttribute("currentUser"); %>
<nav class="navbar navbar-expand-lg" style="background-color: rgba(54,129,168,0.45)">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">MAIN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">ALL ITEMS</a>
                </li>

                <% if (user != null && user.getRole()==2) { %>

                <li class="nav-item">
                    <a class="nav-link" href="/add-item">ADD ITEM</a>
                </li>

                <%
                    }
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/login">LOGIN</a>
                </li>

                <% if(user!=null) {%>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">LOGOUT</a>
                </li>

                <%
                    }
                %>

                <li class="nav-item">
                    <a class="nav-link" href="/all-news">ALL NEWS</a>
                </li>

            </ul>
            <form class="d-flex" role="search" method="get" action="/main">
                <input class="form-control me-2" name="word" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>