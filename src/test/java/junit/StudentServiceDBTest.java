package junit;

import exception.InvalidFormatException;
import model.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import servicesDB.StudentServiceDB;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusIT on 30.07.2017.
 */
public class StudentServiceDBTest {
    private static StudentServiceDB studentServiceDB;

    @BeforeClass
    public static void setup() {
        studentServiceDB = new StudentServiceDB();
    }

    @AfterClass
    public static void teardown() {
        studentServiceDB = null;
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentServiceDB.getAllStudents();
        Assert.assertNotNull(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testGetStudentById() {
        Student student = studentServiceDB.getStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void testCreateStudent() throws InvalidFormatException {
        Student student = new Student();
        int id = 1;
        student.setId(id);
        student.setFirstName("Martin");
        student.setLastName("Scubs");
        studentServiceDB.createStudent(student);
        Student newStudent = studentServiceDB.getStudentById(id);
        Assert.assertNotNull(newStudent);
    }
}
