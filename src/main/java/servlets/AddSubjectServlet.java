package servlets;

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
        new SubjectServiceDB().createSubject(subject);
        resp.sendRedirect("/subjects");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/add_subject.jsp");
        dispatcher.forward(req, resp);
    }
}