package servlets;

import servicesDB.StudentServiceDB;
import servicesDB.SubjectServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_subject")
public class DeleteSubjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
        subjectServiceDB.deleteSubject(subjectServiceDB.getSubjectById(id));
        resp.sendRedirect("/subjects");
    }
}
