package mapper;

import model.Lesson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LessonMapper {
    @Select("SELECT id_lesson, subjects.id_subject, subjects.subject_name, date FROM lessons INNER JOIN subjects ON lessons.id_subject = subjects.id_subject")
    @Results({
            @Result(id = true, column = "id_lesson", property = "idLesson"),
            @Result(column = "id_subject", property = "subject.idSubject"),
            @Result(column = "subject_name", property = "subject.subjectName"),
            @Result(column = "date", property = "date")
    })
    List<Lesson> getAllLessons();

    @Select("SELECT id_lesson, subjects.id_subject, subjects.subject_name, date FROM lessons INNER JOIN subjects ON lessons.id_subject = subjects.id_subject WHERE id_lesson = #{id}")
    @Results({
            @Result(id = true, column = "id_lesson", property = "idLesson"),
            @Result(column = "id_subject", property = "subject.idSubject"),
            @Result(column = "subject_name", property = "subject.subjectName"),
            @Result(column = "date", property = "date")
    })
    Lesson getLessonById(Integer id);

    @Insert("INSERT INTO lessons(id_subject, date) VALUES (#{subject.idSubject}, #{date})")
    void insertLesson(Lesson lesson);
}
