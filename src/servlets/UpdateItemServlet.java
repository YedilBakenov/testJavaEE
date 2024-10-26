package servlets;

import db.DBConnector;
import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.City;
import model.Item;

import java.io.IOException;

@WebServlet(value = "/update-item")
public class UpdateItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String model = request.getParameter("model");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = Integer.parseInt(request.getParameter("id"));
        int city_id = Integer.parseInt(request.getParameter("city_id"));

        City city = DBConnector.getCityById(city_id);

        Item item = DBConnector.getItemById(id);
        item.setId(id);
        item.setDescription(description);
        item.setModel(model);
        item.setPrice(price);
        item.setCity(city);

        DBConnector.updateItem(item);

        response.sendRedirect("/main");
    }
}

