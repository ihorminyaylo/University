package mapper;

import model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM students")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    List<Student> getStudent();

    @Select("SELECT * FROM students WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    Student getStudentById(Integer id);

    @Update("UPDATE students SET (first_name, last_name) = (#{firstName}, #{lastName}) WHERE id = #{id}")
    void updateStudent(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteStudent(Student student);

    @Insert("INSERT INTO students (first_name, last_name) VALUES (#{firstName}, #{lastName})")
    void insertStudent(Student student);
}
