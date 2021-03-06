package mapper;

import model.Lesson;
import model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LessonMapper {
    @Select("SELECT lessons.id, subjects.id AS subject_id, subjects.name, date FROM lessons INNER JOIN subjects ON lessons.subject_id = subjects.id")
    @Results({
            @Result(id = true, column = "id", property = "idLesson"),
            @Result(column = "subject_id", property = "subject.idSubject"),
            @Result(column = "name", property = "subject.subjectName"),
            @Result(column = "date", property = "date")
    })
    List<Lesson> getAllLessons();
    @Select("SELECT lessons.id, subjects.id AS subject_id, subjects.name, date FROM lessons INNER JOIN subjects ON lessons.subject_id = subjects.id WHERE lessons.id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "idLesson"),
            @Result(column = "subject_id", property = "subject.idSubject"),
            @Result(column = "name", property = "subject.subjectName"),
            @Result(column = "date", property = "date")
    })
    Lesson getLessonById(Integer id);

    @Update("UPDATE lessons SET (subject_id, date) = (#{subject.idSubject}, date) WHERE id = #{idLesson}")
    void updateLesson(Lesson lesson);

    @Insert("INSERT INTO lessons(subject_id, date) VALUES (#{subject.idSubject}, #{date})")
    void insertLesson(Lesson lesson);

    @Delete("DELETE FROM lessons WHERE id = #{idLesson}")
    void deleteLesson(Lesson lesson);

    @Select("SELECT lessons.id, subjects.id AS subject_id, subjects.name, date FROM lessons INNER JOIN subjects ON lessons.subject_id = subjects.id WHERE subject_id = #{idSubject}")
    @Results({
            @Result(id = true, column = "id", property = "idLesson"),
            @Result(column = "subject_id", property = "subject.idSubject"),
            @Result(column = "name", property = "subject.subjectName"),
            @Result(column = "date", property = "date")
    })
    List<Lesson> getAllLessonBySubject(Subject subject);
}
