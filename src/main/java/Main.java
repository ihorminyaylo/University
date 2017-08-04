import exception.InvalidFormatException;
import model.*;
import servicesDB.StudentServiceDB;

import java.io.IOException;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        StudentServiceDB studentServiceDB = new StudentServiceDB();
        Student student = studentServiceDB.getStudentById(6);
        studentServiceDB.deleteStudent(student);
    }
}