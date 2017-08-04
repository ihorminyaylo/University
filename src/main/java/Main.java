import exception.InvalidFormatException;
import model.*;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        List<Lesson> lessonList = new LessonServiceDB().getAllLesson();
        List<Mark> markList = new MarkServiceDB().getAllMarksOfStudent(1);
        int hasAllLesson = 0;
        for (Mark mark : markList) {
            mark.setLesson(new LessonServiceDB().getLessonById(mark.getLesson().getIdLesson()));
        }
        System.out.println(lessonList);
    }
}