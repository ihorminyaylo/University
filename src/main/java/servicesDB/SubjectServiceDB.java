package servicesDB;

import exception.InvalidFormatException;
import mapper.StudentMapper;
import mapper.SubjectMapper;
import model.Subject;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubjectServiceDB {

    public void validatorSubject(Subject subject) throws InvalidFormatException {
        String SUBJECT_PATTERN = "[A-Z][a-z]+";
        Pattern pSubjectName = Pattern.compile(SUBJECT_PATTERN);
        Matcher matcher = pSubjectName.matcher(subject.getSubjectName());
        if (!matcher.matches()) {
            throw new InvalidFormatException("The name of subject isn't correct");
        }
    }

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

    public void createSubject(Subject subject) throws InvalidFormatException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            validatorSubject(subject);
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subjectMapper.insertSubject(subject);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateSubject(Subject subject) throws InvalidFormatException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            validatorSubject(subject);
            SubjectServiceDB subjectServiceDB = new SubjectServiceDB();
            for (Subject subject1 : subjectServiceDB.getAllSubjects()) {
                if (subject1.getSubjectName().equals(subject.getSubjectName())) {
                    throw new InvalidFormatException("This date base has this subject name");
                }
            }
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subjectMapper.updateSubject(subject);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteSubject(Subject subject) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subjectMapper.deleteSubject(subject);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public int getCountOfSubject() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            return subjectMapper.getCountOfSubject();
        } finally {
            sqlSession.close();
        }
    }
}
