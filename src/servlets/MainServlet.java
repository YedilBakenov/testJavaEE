package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        PrintWriter writer = response.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<table>");
        writer.print("<thead>");
            writer.print("<tr>");
            writer.print("<th>ID</th>");
            writer.print("<th>NAME</th>");
            writer.print("<th>SURNAME</th>");
            writer.print("<th>GPA</th>");
            writer.print("</tr>");
        writer.print("</thead>");
        writer.print("<tbody>");
            writer.print("<tr>");
            writer.print("<td>1</td>");
            writer.print("<td>SERIK</td>");
            writer.print("<td>SERIKOV</td>");
            writer.print("<td>1</td>");
            writer.print("</tr>");
            writer.print("<tr>");
            writer.print("<td>2</td>");
            writer.print("<td>BERIK</td>");
            writer.print("<td>BERIKOV</td>");
            writer.print("<td>2</td>");
            writer.print("</tr>");
            writer.print("<tr>");
            writer.print("<td>3</td>");
            writer.print("<td>MERIK</td>");
            writer.print("<td>MERIKOV</td>");
            writer.print("<td>3</td>");
            writer.print("</tr>");
        writer.print("</tbody>");
        writer.print("</table>");

        writer.print("</body>");
        writer.print("</html>");

    }
}
