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

@WebServlet(value = "/get-person")
public class GetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        writer.print("<html>");
        writer.print("<head>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<h1>"+ name+"</h1>");
        writer.print("<h1>"+ surname+"</h1>");
        writer.print("</body>");
        writer.print("</html>");

    }
}

