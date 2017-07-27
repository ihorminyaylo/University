package mapper;

import model.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubjectMapper {
    @Select("SELECT * FROM subjects")
    List<Subject> getSubjects();

    /*@Select("SELECT * FROM subjects WHERE id_subject = #{idSubject}")*/
    Subject getSubjectById(Integer id);

    @Insert("INSERT INTO subjects(subject_name) VALUES (#{subject_name})")
    void insertSubject(Subject subject);
}
