package servicesDB;

import mapper.MarkMapper;
import model.Mark;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MarkServiceDB {
    public List<Mark> getAllMarks() {
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
    }
}
