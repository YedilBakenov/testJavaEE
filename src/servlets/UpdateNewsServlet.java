package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;

import java.io.IOException;

@WebServlet(value = "/update-news")
public class UpdateNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));

        News news = DBConnector.getNewsById(id);

        news.setTitle(title);
        news.setContent(content);

        DBConnector.updateNews(news);

        response.sendRedirect("/all-news");
    }
}

