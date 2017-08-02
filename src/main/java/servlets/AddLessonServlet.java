package servlets;

import model.Subject;
import org.apache.ibatis.annotations.Delete;
import servicesDB.SubjectServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_lesson")
public class AddLessonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();


    }
}
