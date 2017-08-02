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

@WebServlet("/edit_lesson")
public class EditLessonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
        Subject subject = subjectServiceDB.getSubjectById(id);
        List<Subject> subjectList = subjectServiceDB.getAllSubjects();
        req.setAttribute("subjectList", subjectList);
        req.setAttribute("subject", subject);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/edit_subject.jsp");
        dispatcher.forward(req, resp);
    }
}
