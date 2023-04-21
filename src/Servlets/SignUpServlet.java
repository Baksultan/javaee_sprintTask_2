package Servlets;

import db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/sign_up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeat_password");
        ArrayList<Users> allUsers = DBManager.getAllUsers();
        int a = 0;

        for (Users u: allUsers) {
            if (u.getEmail().equals(email)) {
                a++;
            }
        }

        if (a==0 && fullName!=null && email!=null && password!=null && password.equals(repeatPassword)) {
            DBManager.addUser(new Users(null, fullName, email, password));
            req.setAttribute("email", email);
            req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
            resp.sendRedirect("/sign_in");
        } else if (password != null && !(password.equals(repeatPassword))) {
            req.setAttribute("password_error", "Passwords do not match");
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
            resp.sendRedirect("/sign_up");
        } else if (a!=0){
            req.setAttribute("error", "User with this email already exists");
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
            resp.sendRedirect("/sign_up");
        }



    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Users> users = DBManager.getAllUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
    }
}
