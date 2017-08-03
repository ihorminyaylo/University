package mapper;

import model.Mark;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MarkMapper {
    /*List<Mark> getAllMarks();

    @Select("SELECT id_mark, journal.id_lesson, score FROM journal INNER JOIN lessons ON lessons.id_lesson = journal.id_lesson WHERE id_mark = #{id}")
    @Results({
        @Result(id = true, column = "id_mark", property = "idMark"),
        @Result(column = "id_lesson", property = "lesson.idLesson"),
        @Result(column = "score", property = "score")
    })
    Mark getMarkById(Integer id);

    @Insert("INSERT INTO journal(id_lesson, score) VALUES (#{lesson.idLesson}, #{score})")
    void insertMark(Mark mark);*/
}
