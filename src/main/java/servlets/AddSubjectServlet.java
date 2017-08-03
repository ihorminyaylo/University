package servlets;

import exception.InvalidFormatException;
import model.Student;
import model.Subject;
import servicesDB.StudentServiceDB;
import servicesDB.SubjectServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_subject")
public class AddSubjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newSubjectName = req.getParameter("newSubjectName");
        Subject subject = new Subject(newSubjectName);
        int validation = 1;
        try {
            new SubjectServiceDB().createSubject(subject);
        } catch (InvalidFormatException e) {
            validation = 0;
        }
        if (validation == 1) {
            resp.sendRedirect("/subjects");
        }
        else {
            req.setAttribute("validation", validation);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_subject.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_subject.jsp");
        dispatcher.forward(req, resp);
    }
}