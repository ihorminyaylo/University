import exception.InvalidFormatException;
import model.*;

import org.testng.annotations.Test;
import service.MarkServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by AsusIT on 25.07.2017.
 */
public class OurCoolTest {
    @Test(expectedExceptions = InvalidFormatException.class)
    public void testIncorrectFullName() throws InvalidFormatException {
        Student student = new Student();
        student.setFirstName("Anna- Maria");
        student.setLastName("Mihailuk      ");
    }

    @Test
    public void testCorrectFullName() throws InvalidFormatException {
        Student student = new Student();
        student.setFirstName("Goergii-Gorngadze");
        student.setLastName("Vizer-Ass");
    }


    @Test
    public void testCorrectAverageScoreBySubject() throws InvalidFormatException {
        Lesson lesson = new Lesson();
        Subject subject = new Subject("English");
        lesson.setSubject(subject);
        lesson.setDate(LocalDate.of(2017,5,25));
        MarkServices markServices = new MarkServices();
        Student student1 = new Student();
        markServices.setStudent(student1);
        markServices.addMarkForStudent(new Mark(lesson, 100));
        Student student2 = new Student();
        markServices.setStudent(student2);
        markServices.addMarkForStudent(new Mark(lesson, 90));
        List<Student> list = new ArrayList<>();
        Journal journal = new Journal();
        journal.setListMarks(list);
        double average = journal.getAverageMarkForSubject(subject);
        //Assert.assertEquals(average, 95);
    }
}
