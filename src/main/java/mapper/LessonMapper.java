package mapper;

import model.Lesson;
import model.Subject;
import org.apache.ibatis.annotations.*;

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

    @Update("UPDATE lessons SET (id_subject, date) = (#{subject.idSubject}, date) WHERE id_lesson = #{idLesson}")
    void updateLesson(Lesson lesson);

    @Insert("INSERT INTO lessons(id_subject, date) VALUES (#{subject.idSubject}, #{date})")
    void insertLesson(Lesson lesson);
}
