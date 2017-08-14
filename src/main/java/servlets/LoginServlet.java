package servlets;

import model.User;

import org.apache.log4j.Logger;
import servicesDB.UserServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";


    private final static Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        User user = new UserServiceDB().getUser(name, pwd);

        if(user != null){
            logger.info("User  " + user.getNameUser() + " logged in");
            HttpSession session = request.getSession();
            session.setAttribute("user", name);
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", name);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("/students");
        }else {
            request.setAttribute("valid", true);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp");
            PrintWriter out= response.getWriter();
            /*out.println("<font color=red>Either user name or password is wrong.</font>");*/
            rd.include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("valid", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        dispatcher.forward(request, response);

    }
}