package servlets.lesson;

import model.Lesson;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;

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

@WebServlet("/lessons")
public class LessonsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        Map<Integer, Boolean> lessonHasMarks = new HashMap<>();
        for (Lesson lesson : lessonList) {
            lessonHasMarks.put(lesson.getIdLesson(), !new MarkServiceDB().getAllMarksOfLesson(lesson).isEmpty());
        }
        req.setAttribute("lessonHasMarks", lessonHasMarks);
        req.setAttribute("lessonList", lessonList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/lessons.jsp");
        dispatcher.forward(req, resp);
    }
}
