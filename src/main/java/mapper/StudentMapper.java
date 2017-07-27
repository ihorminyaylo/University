package mapper;

import model.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(Integer id);
    List<Student> getStudent();
}
