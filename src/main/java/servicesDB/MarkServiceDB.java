package servicesDB;

import exception.InvalidFormatException;
import mapper.MarkMapper;
import model.Lesson;
import model.Mark;
import model.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MarkServiceDB {

    public Mark getMarkById(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            return markMapper.getMarkById(id);
        } finally {
            sqlSession.close();
        }
    }

    public List<Mark> getAllMarksOfStudent(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            return markMapper.getAllMarksOfStudent(id);
        } finally {
            sqlSession.close();
        }
    }

    public void insertMarkForStudent(Mark mark) throws InvalidFormatException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            if (mark.getScore() < 0 || mark.getScore() > 100) {
                throw new InvalidFormatException("This score isn't correct");
            }
            markMapper.insertMarkForStudent(mark);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteMark(Mark mark) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            markMapper.deleteMark(mark);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Mark> getAllMarksOfLesson(Lesson lesson) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            return markMapper.getAllMarksOfLesson(lesson);
        } finally {
            sqlSession.close();
        }
    }
    /*public void updateMarkForStudent(Student student, Integer score) {

    }*/

    /*public List<Mark> getAllMarks() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            return markMapper.getAllMarks();
        } finally {
            sqlSession.close();
        }
    }

    public Mark getMarkById(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            return markMapper.getMarkById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void createMark(Mark mark) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            MarkMapper markMapper = sqlSession.getMapper(MarkMapper.class);
            markMapper.insertMark(mark);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }*/
}
