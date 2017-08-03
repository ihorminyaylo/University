package servlets;

import exception.InvalidFormatException;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/edit_lesson")
public class EditLessonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idLesson = Integer.parseInt(req.getParameter("id"));
        int validation = 1;
        int idSubject;
        idSubject = Integer.parseInt(req.getParameter("newIdSubject"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LessonServiceDB lessonServiceDB = new LessonServiceDB();
        Lesson lesson = lessonServiceDB.getLessonById(idLesson);
        lesson.setSubject(new SubjectServiceDB().getSubjectById(idSubject));
        lesson.setSubject(new SubjectServiceDB().getSubjectById(idSubject));
        try {
            LocalDate date = LocalDate.parse(req.getParameter("newDate"), dateTimeFormatter);
            lesson.setDate(date);
        } catch (InvalidFormatException e) {
            validation = 0;
        } catch (Exception e) {
            validation = 0;
        }

        if (validation == 1) {
            lessonServiceDB.setLesson(lesson);
            resp.sendRedirect("/lessons");
        }
        else {
            List<Subject> subjectList = new SubjectServiceDB().getAllSubjects();
            req.setAttribute("validation", validation);
            req.setAttribute("lesson", lesson);
            req.setAttribute("subjectList", subjectList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_lesson.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idLesson = Integer.parseInt(req.getParameter("id"));
        Lesson lesson = new LessonServiceDB().getLessonById(idLesson);
        List<Subject> subjectList = new SubjectServiceDB().getAllSubjects();
        req.setAttribute("lesson", lesson);
        req.setAttribute("subjectList", subjectList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_lesson.jsp");
        dispatcher.forward(req, resp);
    }
}
