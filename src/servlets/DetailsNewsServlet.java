package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/details-news")
public class DetailsNewsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("news", DBConnector.getNewsById(id));
        request.setAttribute("comments", DBConnector.getCommentsByNewsId(id));

        request.getRequestDispatcher("/news-details.jsp").forward(request, response);
    }

}

