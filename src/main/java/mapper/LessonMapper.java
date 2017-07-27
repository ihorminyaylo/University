package mapper;

import model.Lesson;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface LessonMapper {
    List<Lesson> getAllLessons();

    Lesson getLessonById();

    @Insert({"INSERT INTO lessons(id_subject, date}) VALUES(#{id_subjec}, #{firstName})"})
    void insertLesson(Lesson lesson);
}
