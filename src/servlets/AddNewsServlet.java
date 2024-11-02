package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;
import model.User;

import java.io.IOException;

@WebServlet(value = "/add-news")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int user_id =Integer.parseInt(request.getParameter("user_id"));

            User user = DBConnector.getUserById(user_id);

            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setUser(user);

            DBConnector.addNews(news);

            response.sendRedirect("/all-news");

    }
}

