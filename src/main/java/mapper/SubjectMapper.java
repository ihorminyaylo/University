package mapper;

import model.Student;
import model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {

    @Select("SELECT * FROM subjects")
    @Results({
            @Result(id = true, column = "id_subject", property = "idSubject"),
            @Result(column = "subject_name", property = "subjectName")
    })
    List<Subject> getSubjects();

    @Select("SELECT * FROM subjects WHERE id_subject = #{idSubject}")
    @Results({
        @Result(id = true, column = "id_subject", property = "idSubject"),
        @Result(column = "subject_name", property = "subjectName")
    })
    Subject getSubjectById(Integer id);

    @Update("UPDATE subjects SET (subject_name) = (#{subjectName}) WHERE id_subject = #{idSubject}")
    void updateSubject(Subject subject);

    @Delete("DELETE FROM subjects WHERE id_subject = #{idSubject}")
    void deleteSubject(Subject subject);

    @Insert("INSERT INTO subjects(subject_name) VALUES (#{subjectName})")
    void insertSubject(Subject subject);
}
