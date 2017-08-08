package servlets;

import model.Mark;
import model.Student;
import org.apache.ibatis.annotations.Select;
import service.PaginationService;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;

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

@WebServlet("")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*int current = Integer.parseInt(req.getParameter("current"));*/
        List<Student> students = new StudentServiceDB().getAllStudents();
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Map<Integer, Boolean> studentHasMarks = new HashMap<>();
        for (Student student : students) {
            List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(student.getId());
            studentHasMarks.put(student.getId(), !markList.isEmpty());
        }
        /*PaginationService paginationService = new PaginationService(5, 5, current);
        req.setAttribute("pagination", paginationService);*/
        req.setAttribute("studentHasMarks", studentHasMarks);
        req.setAttribute("students", students);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
