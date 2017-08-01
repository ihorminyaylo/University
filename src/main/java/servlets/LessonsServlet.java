package servlets;

import model.Lesson;
import servicesDB.LessonServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lessons")
public class LessonsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        req.setAttribute("lessonList", lessonList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/lessons.jsp");
        dispatcher.forward(req, resp);
    }
}
