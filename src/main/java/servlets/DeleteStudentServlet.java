package servlets;

import model.Mark;
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

@WebServlet("/delete_student")
public class DeleteStudentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(id);
        if (markList.isEmpty()) {
            studentServiceDB.deleteStudent(studentServiceDB.getStudentById(id));
        }
        else {
            req.setAttribute("studentHasMarks", 0);
        }
        resp.sendRedirect("/");
    }
}
