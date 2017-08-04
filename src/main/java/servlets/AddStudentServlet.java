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
        Student student = new Student();
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
            new StudentServiceDB().insertStudent(student);
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("validationFirstName", validationFirstName);
            req.setAttribute("validationLastName", validationLastName);
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
