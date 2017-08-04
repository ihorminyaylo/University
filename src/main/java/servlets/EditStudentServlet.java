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
        int validationFirstName = 1;
        int validationLastName = 1;
        try {
            student.setFirstName(newFirstName);
        } catch (InvalidFormatException e) {
            validationFirstName = 0;
        }
        try {
            student.setLastName(newLastName);
        } catch (InvalidFormatException e) {
            validationLastName = 0;
        }
        if (validationFirstName == 1 && validationLastName == 1) {
            studentServiceDB.updateStudent(student);
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("student", student);
            req.setAttribute("validationFirstName", validationFirstName);
            req.setAttribute("validationLastName", validationLastName);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_student.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = new StudentServiceDB().getStudentById(id);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/edit_student.jsp");
        dispatcher.forward(req, resp);
    }
}
