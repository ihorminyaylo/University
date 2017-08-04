package servlets;

import model.Mark;
import model.Student;
import org.apache.ibatis.annotations.Select;
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

@WebServlet("")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new StudentServiceDB().getAllStudents();
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        for (Student student : students) {
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(student.getId());
            if (!markList.isEmpty()) {
                req.setAttribute("studentHasMarks", true);
            }
        }
        req.setAttribute("students", students);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
