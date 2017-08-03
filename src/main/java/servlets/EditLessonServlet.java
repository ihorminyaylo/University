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
        int idSubject = Integer.parseInt(req.getParameter("newIdSubject"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(req.getParameter("newDate"), dateTimeFormatter);
        LessonServiceDB lessonServiceDB =  new LessonServiceDB();
        Lesson lesson = lessonServiceDB.getLessonById(idLesson);
        lesson.setSubject(new SubjectServiceDB().getSubjectById(idSubject));
        try {
            lesson.setDate(date);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        lessonServiceDB.setLesson(lesson);
        resp.sendRedirect("/lessons");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Lesson lesson = new LessonServiceDB().getLessonById(id);
        List<Subject> subjectList = new SubjectServiceDB().getAllSubjects();
        req.setAttribute("lesson", lesson);
        req.setAttribute("subjectList", subjectList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/edit_lesson.jsp");
        dispatcher.forward(req, resp);
    }
}
