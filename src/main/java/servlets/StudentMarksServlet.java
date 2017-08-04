package servlets;

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
import java.util.List;

@WebServlet("/student/marks")
public class StudentMarksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Student student = studentServiceDB.getStudentById(id);
        List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
        for (Mark mark : markList) {
            mark.setLesson(new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson()));
        }
        req.setAttribute("student", student);
        req.setAttribute("markList", markList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/student_marks.jsp");
        dispatcher.forward(req , resp);
    }
}
