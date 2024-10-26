package servlets;

import db.DBConnector;
import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Item> items = DBConnector.getAllItems();

        request.setAttribute("goroda", DBConnector.getAllCities());
        request.setAttribute("spisok", items);

        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

}

