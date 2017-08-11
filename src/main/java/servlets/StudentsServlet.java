package servlets;

import model.Mark;
import model.Student;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter().doFilter(req, resp ,);
        List<Student> students = new StudentServiceDB().getAllStudents();
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Map<Integer, Boolean> studentHasMarks = new HashMap<>();
        for (Student student : students) {
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(student.getId());
            studentHasMarks.put(student.getId(), !markList.isEmpty());
        }
        int currentPage;
        try {
            currentPage = Integer.parseInt(req.getParameter("current"));
        } catch (Exception e) {
            currentPage = 1;
        }
        int totalCount = studentServiceDB.getCountOfStudent();
        req.setAttribute("action", true);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("pageSize", 3);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("studentHasMarks", studentHasMarks);
        req.setAttribute("students", students);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/students.jsp");
        requestDispatcher.forward(req, resp);
    }
}
