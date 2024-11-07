package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comment;
import model.News;
import model.User;

import java.io.IOException;

@WebServlet(value = "/add-comment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content = request.getParameter("content");
        int newsId = Integer.parseInt(request.getParameter("news_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));

        News news = DBConnector.getNewsById(newsId);
        User user = DBConnector.getUserById(userId);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setNews(news);
        comment.setText(content);

        DBConnector.addComment(comment);

        response.sendRedirect("/details-news?id="+newsId);

    }
}

