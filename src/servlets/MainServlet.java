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

        String word = request.getParameter("word");

        if(word!=null){
            request.setAttribute("spisok", DBConnector.getAllItemsBySearch("%"+ word + "%"));
            request.setAttribute("goroda", DBConnector.getAllCities());
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }else {
                request.setAttribute("goroda", DBConnector.getAllCities());
                request.setAttribute("spisok", items);
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            }
    }
}

