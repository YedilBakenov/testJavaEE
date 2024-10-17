package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<table>");
        writer.print("<thead>");
        writer.print("<tr>");
        writer.print("<th>ID</th>");
        writer.print("<th>MODEL</th>");
        writer.print("<th>DESCRIPTION</th>");
        writer.print("<th>PRICE</th>");
        writer.print("</tr>");
        writer.print("</thead>");
        writer.print("<tbody>");

        for (Item item : DBManager.getAllItems()) {
            writer.print("<tr>");
            writer.print("<td>" + item.getId() + "</td>");
            writer.print("<td>" + item.getModel() + "</td>");
            writer.print("<td>" + item.getDescription() + "</td>");
            writer.print("<td>" + item.getPrice() + "</td>");
            writer.print("</tr>");
        }

        writer.print("</tbody>");
        writer.print("</table>");

        writer.print("<form style='margin-top:20px;' method = 'post' action ='/main'>");
        writer.print("<label>MODEL:</label> <br>");
        writer.print("<input type='text' name='model'> <br>");
        writer.print("<label>DESCRIPTION:</label> <br>");
        writer.print("<input type='text' name='description'> <br>");
        writer.print("<label>PRICE:</label> <br>");
        writer.print("<input type='number' name='price'> <br>");
        writer.print("<button style ='color: green'>ADD ITEM</button>");
        writer.print("</form>");

        writer.print("<form style='margin-top:20px;' method = 'get' action ='/get-person'>");
        writer.print("<label>NAME:</label> <br>");
        writer.print("<input type='text' name='name'> <br>");
        writer.print("<label>SURNAME:</label> <br>");
        writer.print("<input type='text' name='surname'> <br>");
        writer.print("<button style ='color: green'>SEND</button>");
        writer.print("</form>");


        writer.print("</body>");
        writer.print("</html>");


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

        DBManager.addItem(item);

        response.sendRedirect("/main");
    }
}

