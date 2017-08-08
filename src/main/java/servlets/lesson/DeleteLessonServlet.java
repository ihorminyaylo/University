package servlets.lesson;

import exception.InvalidFormatException;
import model.Lesson;
import model.Subject;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/delete_lesson")
public class DeleteLessonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idLesson = Integer.parseInt(req.getParameter("id"));
        LessonServiceDB lessonServiceDB = new LessonServiceDB();
        Lesson deleteLesson = lessonServiceDB.getLessonById(idLesson);
        if (new MarkServiceDB().getAllMarksOfLesson(deleteLesson).isEmpty()) {
            lessonServiceDB.deleteLesson(deleteLesson);
        }
        else {

        }
        lessonServiceDB.deleteLesson(deleteLesson);
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        Map<Lesson, Boolean> lessonHasMarks = new HashMap<>();
        for (Lesson lesson : lessonList) {
            if (new MarkServiceDB().getAllMarksOfLesson(lesson).isEmpty()) {
                lessonHasMarks.put(lesson, false);
            } else {
                lessonHasMarks.put(lesson, true);
            }
        }
        req.setAttribute("lessonHasMarks", lessonHasMarks);
        req.setAttribute("lessonList", lessonList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/lessons.jsp");
        dispatcher.forward(req, resp);
    }
}
