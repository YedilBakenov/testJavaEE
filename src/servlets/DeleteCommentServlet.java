package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete-comment")
public class DeleteCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int commentId = Integer.parseInt(request.getParameter("comment_id"));
        int newsId = Integer.parseInt(request.getParameter("news_id"));

        DBConnector.deleteCommentById(commentId);

        response.sendRedirect("/details-news?id="+newsId);
    }
}

