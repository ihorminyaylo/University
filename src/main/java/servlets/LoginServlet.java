package servlets;

import model.Mark;
import model.Student;
import model.User;
import org.apache.ibatis.annotations.Select;
import service.PaginationService;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;
import servicesDB.UserServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String name = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        User user = new UserServiceDB().getUser(name, pwd);

        if(user.getNameUser().equals(name) && user.getPassword().equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", "Pankaj");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", name);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("/students");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/login.html");
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