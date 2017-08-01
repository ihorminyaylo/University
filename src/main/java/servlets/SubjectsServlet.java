package servlets;

import model.Subject;
import servicesDB.SubjectServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects = new SubjectServiceDB().getAllSubjects();
        req.setAttribute("subjects", subjects);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/subjects.jsp");
        dispatcher.forward(req, resp);
    }
}
