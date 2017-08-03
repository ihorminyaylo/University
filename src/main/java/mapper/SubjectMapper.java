package mapper;

import model.Student;
import model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {

    @Select("SELECT * FROM subjects")
    @Results({
            @Result(id = true, column = "id", property = "idSubject"),
            @Result(column = "name", property = "subjectName")
    })
    List<Subject> getSubjects();

    @Select("SELECT * FROM subjects WHERE id = #{idSubject}")
    @Results({
        @Result(id = true, column = "id", property = "idSubject"),
        @Result(column = "name", property = "subjectName")
    })
    Subject getSubjectById(Integer id);

    @Update("UPDATE subjects SET (name) = (#{subjectName}) WHERE id = #{idSubject}")
    void updateSubject(Subject subject);

    @Delete("DELETE FROM subjects WHERE id = #{idSubject}")
    void deleteSubject(Subject subject);

    @Insert("INSERT INTO subjects(name) VALUES (#{subjectName})")
    void insertSubject(Subject subject);
}
