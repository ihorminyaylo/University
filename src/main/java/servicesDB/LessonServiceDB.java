package servicesDB;

import mapper.LessonMapper;
import model.Lesson;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LessonServiceDB {
    public List<Lesson> getAllLesson() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            return lessonMapper.getAllLessons();
        } finally {
            sqlSession.close();
        }
    }

    public Lesson getLessonById(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            return lessonMapper.getLessonById();
        } finally {
            sqlSession.close();
        }
    }

    public void createLesson(Lesson lesson) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            lessonMapper.insertLesson(lesson);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
