package mapper;

import model.Lesson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.util.List;

public interface LessonMapper {
    @Select("SELECT id_subject, date FROM lessons INNER JOIN subjects ON lessons.id_subject = subjects.id_subject")
    @Results({
            @Result(id = true, column = "id_lesson", property = "idLesson"),
            @Result(column = "subject", property = "subject.idSubject"),
            @Result(column = "date", property = "date")
    })
    List<Lesson> getAllLessons();

    @Select("SELECT subject_name, id_subject, date FROM lessons WHERE id_lesson = #{id}  INNER JOIN subjects ON lessons.id_subject = subjects.id_subject")
    @Results({
            @Result(id = true, column = "id_lesson", property = "idLesson"),
            @Result(column = "subject_name", property = "subjectName"),
            @Result(column = "id_subject", property = "idSubject"),
            @Result(column = "date", property = "date")
    })
    Lesson getLessonById(Integer id);

    @Insert("INSERT INTO lessons(id_subject, date) VALUES (#{subject.idSubject}, #{date})")
    void insertLesson(Lesson lesson);
}
