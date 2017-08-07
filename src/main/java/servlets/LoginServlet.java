package servlets;

import exception.InvalidFormatException;
import model.User;
import servicesDB.LoginServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AsusIT on 03.08.2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("psw");
        LoginServiceDB loginServiceDB = new LoginServiceDB();
        User user = new User();
        boolean s = true;
        try {
            user = loginServiceDB.enterUser(name, password);
        } catch (InvalidFormatException e) {
            s = false;
        }
        if (s) {
            resp.sendRedirect("/");
        }
        else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
        dispatcher.forward(req, resp);
    }
}
