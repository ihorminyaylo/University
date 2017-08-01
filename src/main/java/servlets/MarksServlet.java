package servlets;

import model.Mark;
import servicesDB.MarkServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/marks")
public class MarksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Mark> markList = new MarkServiceDB().getAllMarks();
        req.setAttribute("markList", markList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("marks.jsp");
        dispatcher.forward(req, resp);
    }
}
