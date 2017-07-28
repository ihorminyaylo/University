package mapper;

import model.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

    @Insert("INSERT INTO subjects(subject_name) VALUES (#{subjectName})")
    void insertSubject(Subject subject);
}
