package mapper;

import model.Lesson;
import model.Mark;
import model.Student;
import model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MarkMapper {

    @Select("SELECT * FROM marks WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "idMark"),
            @Result(column = "lesson_id", property = "lesson.idLesson"),
            @Result(column = "student_id", property = "student.id"),
            @Result(column = "score", property = "score")
    })
    Mark getMarkById(Integer id);

    @Select("SELECT marks.id,lessons.id AS lesson_id, lessons.date, score FROM marks INNER JOIN lessons ON lessons.id = marks.lesson_id WHERE student_id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "idMark"),
            @Result(column = "lesson_id", property = "lesson.idLesson"),
            @Result(column = "score", property = "score")
    })
    List<Mark> getAllMarksOfStudent(Integer id);

    @Select("SELECT marks.id, lessons.date, score FROM marks INNER JOIN lessons ON lessons.id = marks.lesson_id WHERE lessons.id = #{idLesson}")
    @Results({
        @Result(id = true, column = "id", property = "idMark"),
        @Result(column = "date", property = "lesson.date"),
        @Result(column = "score", property = "score")
    })
    List<Mark> getAllMarksOfLesson(Lesson lesson);


    @Insert("INSERT INTO marks(student_id, lesson_id, score) VALUES (#{student.id}, #{lesson.idLesson}, #{score})")
    void insertMarkForStudent(Mark mark);

    @Delete("DELETE FROM marks WHERE id = #{idMark}")
    void deleteMark(Mark mark);

    @Update("UPDATE marks SET(score) = ('#{score}') WHERE id = #{idMark}")
    void updateMark(Mark mark);
}
