package servlets;

import lombok.extern.log4j.Log4j;
import model.User;

import servicesDB.UserServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@WebServlet("/LoginServlet")
@Log4j
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("../logs/userslogs.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        User user = new UserServiceDB().getUser(name, pwd);

        if(user != null){
            logger.info("Login - User : " + user.getNameUser());
            HttpSession session = request.getSession();
            session.setAttribute("user", name);
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", name);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("/students");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        dispatcher.forward(req, resp);
    }
}