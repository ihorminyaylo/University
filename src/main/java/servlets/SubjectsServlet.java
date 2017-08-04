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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects = new SubjectServiceDB().getAllSubjects();
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        Map<Subject, Boolean> subjectHasLesson = new HashMap<>();
        for (Subject subject : subjects) {
            boolean b = false;
            for (Lesson lesson : lessonList) {
                if (lesson.getSubject().getIdSubject() == subject.getIdSubject()) {
                    b = true;
                }
            }
            subjectHasLesson.put(subject, b);
            b = false;
        }
        req.setAttribute("subjectHasLesson", subjectHasLesson);
        req.setAttribute("subjects", subjects);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/subjects.jsp");
        dispatcher.forward(req, resp);
    }
}
