package servlets;

import exception.InvalidFormatException;
import model.Lesson;
import model.Mark;
import model.Student;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/marks/add_mark")
public class AddMarkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = new StudentServiceDB().getStudentById(id);
        int idLesson = Integer.parseInt(req.getParameter("lesson"));
        Lesson lesson = new LessonServiceDB().getLessonById(idLesson);
        int validation = 1;
        int score = 0;
        try {
            score = Integer.parseInt(req.getParameter("score"));
        } catch (Exception e) {
            validation = 0;
        }
        if (validation == 1) {
            try {
                new MarkServiceDB().insertMarkForStudent(new Mark(lesson, student, score));
            } catch (InvalidFormatException e) {
                validation = 0;
            }
        }
        if (validation == 1) {
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
            for (Mark mark : markList) {
                mark.setLesson(new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson()));
            }
            req.setAttribute("student", student);
            req.setAttribute("markList", markList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/student_marks.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            req.setAttribute("validation", validation);
            List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
            for (Mark mark : markList) {
                Iterator<Lesson> iterator = lessonList.iterator();
                while (iterator.hasNext()) {
                    Lesson checkLesson = iterator.next();
                    if (lesson.getIdLesson() == mark.getLesson().getIdLesson()) {
                        iterator.remove();
                    }
                }
            }
            req.setAttribute("student", student);
            req.setAttribute("lessonList", lessonList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_mark.jsp");
            dispatcher.forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Student student = studentServiceDB.getStudentById(id);
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
        int hasAllLesson = 0;
        if (markList.size() == lessonList.size()) {
            for (Mark mark : markList) {
                mark.setLesson(new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson()));
            }
            req.setAttribute("hasAllLesson", hasAllLesson);
            req.setAttribute("student", student);
            req.setAttribute("markList", markList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/student_marks.jsp");
            dispatcher.forward(req , resp);
        }
        else {
            for (Mark mark : markList) {
                Iterator<Lesson> iterator = lessonList.iterator();
                while (iterator.hasNext()) {
                    Lesson lesson = iterator.next();
                    if (lesson.getIdLesson() == mark.getLesson().getIdLesson()) {
                        iterator.remove();
                    }
                }
            }
        }
        System.out.println(lessonList);
        req.setAttribute("student", student);
        req.setAttribute("lessonList", lessonList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_mark.jsp");
        dispatcher.forward(req , resp);
    }
}
