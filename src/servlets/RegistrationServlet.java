package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/registration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        User userFromBase = DBConnector.getUserByEmail(email);

        if(userFromBase!=null){
            response.sendRedirect("/login");
        } else if (!password.equals(rePassword)) {
            response.sendRedirect("/login");
        }else {
            User newUser = new User();
            newUser.setFullName(fullName);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setRole(1);

            DBConnector.addUser(newUser);

            response.sendRedirect("/main");
        }
    }
}

