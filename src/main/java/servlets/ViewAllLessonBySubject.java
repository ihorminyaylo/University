package servlets;

import model.Lesson;
import model.Subject;
import servicesDB.LessonServiceDB;
import servicesDB.SubjectServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view_all_lesson")
public class ViewAllLessonBySubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idSubject = Integer.parseInt(req.getParameter("id"));
        Subject subject = new SubjectServiceDB().getSubjectById(idSubject);
        List<Lesson> lessonList = new LessonServiceDB().getAllLessonBySubject(subject);
        req.setAttribute("lessonList", lessonList);
        req.setAttribute("subject", subject);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/lesson_by_subject.jsp");
        dispatcher.forward(req, resp);
    }
}
