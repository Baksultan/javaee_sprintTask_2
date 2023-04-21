package Servlets;

import db.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/sign_in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ArrayList<Users> allUsers = DBManager.getAllUsers();

        int a = 0;
        for (Users u: allUsers) {
            if (u.getEmail().equals(email)) {
                a+=2;
            }
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                req.setAttribute("user", u.getFullName());
                req.getRequestDispatcher("/userProfile.jsp").forward(req, resp);
                a++;
            }
        }

        if (a==0) {
            req.setAttribute("error", "Incorrect email or password!");
            req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
        } else if (a==2) {
            req.setAttribute("incorrect_password", "Incorrect password!");
            req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/user_page");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Users> users = DBManager.getAllUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/signIn.jsp").forward(req, resp);

    }
}
