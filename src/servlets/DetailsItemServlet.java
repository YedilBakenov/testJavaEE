package servlets;

import db.DBConnector;
import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/item-details")
public class DetailsItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("obj", DBConnector.getItemById(id));

        request.getRequestDispatcher("/item-details.jsp").forward(request, response);
    }

}

