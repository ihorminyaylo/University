import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Create MarkServices
        MarkServices markServices = new MarkServices();
        // Create lessons
        Lesson english1 = new Lesson(Subject.English, LocalDate.of(2017,5,30));
        Lesson english2 = new Lesson(Subject.English, LocalDate.of(2017,5,29));
        Lesson math1 = new Lesson(Subject.Mathematic, LocalDate.of(2017,5,30));
        Lesson math2 = new Lesson(Subject.Mathematic, LocalDate.of(2017,5,29));

        // Create student 1 and add mark for the student
        Student st1 = new Student();
        st1.setFirstName("Ihor");
        st1.setLastName("Minyaylo");
        markServices.setStudent(st1);
        markServices.addMarkForStudent(new Mark(english1, 90));
        markServices.addMarkForStudent(new Mark(english2, 93));
        markServices.addMarkForStudent(new Mark(math1, 99));
        markServices.addMarkForStudent(new Mark(math2, 93));

        // Create student 2 and add mark for the student
        Student st2 = new Student();
        st2.setFirstName("Ihor");
        st2.setLastName("Kirilov");
        markServices.setStudent(st2);
        markServices.addMarkForStudent(new Mark(english1, 86));
        markServices.addMarkForStudent(new Mark(english2, 96));
        markServices.addMarkForStudent(new Mark(math1, 81));
        markServices.addMarkForStudent(new Mark(math2, 63));

        // Create student 3 and add mark for the student
        Student st3 = new Student();
        st3.setFirstName("Mykola");
        st3.setLastName("Huska");
        markServices.setStudent(st3);
        markServices.addMarkForStudent(new Mark(english1, 75));
        markServices.addMarkForStudent(new Mark(english2, 67));
        markServices.addMarkForStudent(new Mark(math1, 77));
        markServices.addMarkForStudent(new Mark(math2, 81));

        // add marks for students

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);

        Journal journal = new Journal();
        System.out.println(st1.getListMarks());
        journal.setListMarks(students);

        System.out.println("Average score of English - " + journal.getAverageMarkForSubject(Subject.English));
        System.out.println("Subjects of 30/05/2017 : " + journal.getSubjectsOfDate(LocalDate.of(2017,5,30)));
        System.out.println("Lessons(dates) of Subject - " + journal.getLessonsOfSubject(Subject.English));


        SqlSessionFactory sqlSessionFactory;
        StudentMapper studentMapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            studentMapper = sqlSessionFactory.openSession().getMapper(StudentMapper.class);
            //List<Student> studentDB = studentMapper.getStudent();
            Student student = studentMapper.getStudentById(1);
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }
