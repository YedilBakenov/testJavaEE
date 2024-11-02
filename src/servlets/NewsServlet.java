package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;
import model.News;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/all-news")
public class NewsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<News> news = DBConnector.getAllNews();

        request.setAttribute("news", DBConnector.getAllNews());

        request.getRequestDispatcher("/all-news.jsp").forward(request, response);
    }

}

