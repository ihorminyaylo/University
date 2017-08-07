package servicesDB;

import mapper.LessonMapper;
import model.Lesson;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LessonServiceDB {

    public void validatorLesson(Lesson lesson) {

    }

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
            return lessonMapper.getLessonById(id);
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

    public void setLesson(Lesson lesson) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            lessonMapper.updateLesson(lesson);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteLesson(Lesson lesson) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);
            lessonMapper.deleteLesson(lesson);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
