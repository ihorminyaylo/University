package servlets;

import exception.InvalidFormatException;
import model.Student;
import servicesDB.StudentServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_student")
public class AddStudentServlet extends HomeServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newFirstName = req.getParameter("newFirstName");
        String newLastName = req.getParameter("newLastName");
        Student student = null;
        int validation = 1;
        try {
            student = new Student(newFirstName, newLastName);
        } catch (InvalidFormatException e) {
            validation = 0;
        }
        if (validation == 1) {
            new StudentServiceDB().insertStudent(student);
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("validation", validation);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_student.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_student.jsp");
        dispatcher.forward(req, resp);
    }
}
