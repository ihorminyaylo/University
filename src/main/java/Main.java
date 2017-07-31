import exception.InvalidFormatException;
import mapper.MarkMapper;
import mapper.StudentMapper;
import mapper.SubjectMapper;
import model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.MarkServices;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;
import servicesDB.SubjectServiceDB;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        /*MarkServiceDB markServiceDB = new MarkServiceDB();
        LessonServiceDB lessonServiceDB = new LessonServiceDB();
        SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
        Lesson lesson = lessonServiceDB.getLessonById(11);
        markServiceDB.createMark(new Mark(lesson, 98));*/

        System.out.println(new StudentServiceDB().getAllStudents());
    }
}