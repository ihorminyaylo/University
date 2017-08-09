package servlets.import_export;

import io.JSON;
import model.Student;
import servicesDB.StudentServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/export")
public class ExportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        List<Student> list = new ArrayList<>();
        list.addAll(new StudentServiceDB().getAllStudents());
        JSON.objectToFile(file, list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/export.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/export.jsp");
        dispatcher.forward(req, resp);
    }
}
