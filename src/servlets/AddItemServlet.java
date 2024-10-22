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

@WebServlet(value = "/add-item")
public class AddItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.sendRedirect("/add-item.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String model = request.getParameter("model");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Item item = new Item();
        item.setDescription(description);
        item.setModel(model);
        item.setPrice(price);

        DBConnector.addItem(item);

        response.sendRedirect("/main");
    }
}

