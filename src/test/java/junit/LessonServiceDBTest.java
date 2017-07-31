package junit;

import exception.InvalidFormatException;
import model.Lesson;
import model.Subject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import servicesDB.LessonServiceDB;
import org.junit.*;
import servicesDB.SubjectServiceDB;

import java.time.LocalDate;
import java.util.List;

public class LessonServiceDBTest {
    private static LessonServiceDB lessonServiceDB;

    @BeforeClass
    public static void setup() {
        lessonServiceDB = new LessonServiceDB();
    }

    @AfterClass
    public static void teardown() {
        lessonServiceDB = null;
    }

    @Test
    public void testGetAllLesson() {
        List<Lesson> lessonList = lessonServiceDB.getAllLesson();
        Assert.assertNotNull(lessonList);
        for (Lesson lesson : lessonList) {
            System.out.println(lesson);
        }
    }

    @Test
    public void testGetLessonById() throws InvalidFormatException {
        Lesson lesson = lessonServiceDB.getLessonById(1);
        Assert.assertNotNull(lesson);
        System.out.println(lesson);
    }

    /*@Test
    public void testCreateLesson() throws InvalidFormatException {
        Lesson lesson = new Lesson();
        int id = 1;
        lesson.setIdLesson(id);
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
        Subject subject = subjectServiceDB.getSubjectById(1);
        lesson.setSubject(subject);
        lesson.setDate(LocalDate.of(2017,5,12));
        Lesson newLesson = lessonServiceDB.getLessonById(id);
        Assert.assertNotNull(newLesson);
    }*/
}
