package servlets;

import exception.InvalidFormatException;
import model.Lesson;
import model.Subject;
import org.apache.ibatis.annotations.Delete;
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

@WebServlet("/add_lesson")
public class AddLessonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idSubject = Integer.parseInt(req.getParameter("newIdSubject"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LessonServiceDB lessonServiceDB =  new LessonServiceDB();
        int validation = 1;
        LocalDate date = null;
        try {
            date = LocalDate.parse(req.getParameter("newDate"), dateTimeFormatter);
        } catch (Exception e) {
            validation = 0;
        }
        if (validation == 1) {
            try {
                lessonServiceDB.createLesson(new Lesson(new SubjectServiceDB().getSubjectById(idSubject), date));
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/lessons");
        }
        else {
            List<Subject> subjectList = new SubjectServiceDB().getAllSubjects();
            req.setAttribute("validation", validation);
            req.setAttribute("subjectList", subjectList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_lesson.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjectList = new SubjectServiceDB().getAllSubjects();
        req.setAttribute("subjectList", subjectList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_lesson.jsp");
        dispatcher.forward(req, resp);
    }
}
