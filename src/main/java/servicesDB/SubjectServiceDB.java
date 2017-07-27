package servicesDB;

import mapper.SubjectMapper;
import model.Subject;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubjectServiceDB {
    public List<Subject> getAllSubjects() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            return subjectMapper.getSubjects();
        } finally {
            sqlSession.close();
        }
    }

    public Subject getSubjectById(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            return subjectMapper.getSubjectById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void createSubject(Subject subject) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subjectMapper.insertSubject(subject);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
