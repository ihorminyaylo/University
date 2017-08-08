package servlets.mark;

import exception.InvalidFormatException;
import model.Lesson;
import model.Mark;
import model.Student;
import service.StudentServices;
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
import java.util.List;

@WebServlet("/marks/edit_score")
public class EditScoreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idMark = Integer.parseInt(req.getParameter("idMark"));
        int newScore = Integer.parseInt(req.getParameter("score"));
        MarkServiceDB markServiceDB = new MarkServiceDB();
        Mark Mark = markServiceDB.getMarkById(idMark);
        boolean b = true;
        try {
            Mark.setScore(newScore);
        } catch (InvalidFormatException e) {
            b = false;
        }
        try {
            new MarkServiceDB().updateMark(Mark);
        } catch (InvalidFormatException e) {
            b = false;
        }
        if (b == true) {
            int id = Integer.parseInt(req.getParameter("id"));
            StudentServiceDB studentServiceDB = new StudentServiceDB();
            Student student = studentServiceDB.getStudentById(id);
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
            for (Mark mark : markList) {
                mark.setLesson(new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson()));
            }
            req.setAttribute("averageScore", new StudentServices().getAverageMarkForStudent(markList));
            req.setAttribute("student", student);
            req.setAttribute("markList", markList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/student_marks.jsp");
            dispatcher.forward(req , resp);
        }
        else {
            Mark mark = new MarkServiceDB().getMarkById(idMark);
            Lesson lesson = new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson());
            Student student = new StudentServiceDB().getStudentById(mark.getStudent().getId());
            req.setAttribute("mark", mark);
            req.setAttribute("lesson", lesson);
            req.setAttribute("student", student);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_score.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idMark = Integer.parseInt(req.getParameter("id"));
        Mark mark = new MarkServiceDB().getMarkById(idMark);
        Lesson lesson = new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson());
        Student student = new StudentServiceDB().getStudentById(mark.getStudent().getId());
        req.setAttribute("mark", mark);
        req.setAttribute("lesson", lesson);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_score.jsp");
        dispatcher.forward(req, resp);
    }
}
