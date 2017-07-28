package mapper;

import model.Mark;

import java.util.List;

public interface MarkMapper {
    List<Mark> getAllMarks();
    Mark getMarkById(Integer id);
    void insertMark(Mark mark);
}
