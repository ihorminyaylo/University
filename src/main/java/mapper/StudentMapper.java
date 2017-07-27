package mapper;

import model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    /*@Select("SELECT * FROM STUDENTS")*/
    List<Student> getStudent();

    /*@Select("SELECT * FROM students WHERE id = #{id}")*/
    Student getStudentById(Integer id);

    @Insert("INSERT INTO students (first_name, last_name) VALUES (#{firstName}, #{lastName})")
    void insertStudent(Student student);
}
