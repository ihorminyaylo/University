package servlets;

import exception.InvalidFormatException;
import model.Student;
import servicesDB.StudentServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_student")
public class EditStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Student student = studentServiceDB.getStudentById(id);
        String newFirstName = req.getParameter("newFirstName");
        String newLastName = req.getParameter("newLastName");
        try {
            student.setFirstName(newFirstName);
            student.setLastName(newLastName);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        studentServiceDB.setStudent(student);
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = new StudentServiceDB().getStudentById(id);
        req.setAttribute("id", id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/edit_student.jsp");
        dispatcher.forward(req, resp);
    }
}
