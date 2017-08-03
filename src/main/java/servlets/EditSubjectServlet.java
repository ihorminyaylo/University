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

@WebServlet("/edit_subject")
public class EditSubjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newSubjectName = req.getParameter("newSubjectName");
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
        Subject subject = subjectServiceDB.getSubjectById(id);
        subject.setSubjectName(newSubjectName);
        int validation = 1;
        try {
            subjectServiceDB.updateSubject(subject);
        } catch (InvalidFormatException e) {
            validation = 0;
        }
        if (validation ==1) {
            resp.sendRedirect("/subjects");
        }
        else {
            req.setAttribute("validation", validation);
            req.setAttribute("subject", subject);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_subject.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Subject subject = new SubjectServiceDB().getSubjectById(id);
        req.setAttribute("subject", subject);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_subject.jsp");
        dispatcher.forward(req, resp);
    }
}
