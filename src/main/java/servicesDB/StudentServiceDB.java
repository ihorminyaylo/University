package servicesDB;

import mapper.StudentMapper;
import model.Student;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.PaginationService;

import java.util.List;

public class StudentServiceDB {

    public List<Student> getAllStudents() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudent();
        } finally {
            sqlSession.close();
        }
    }

    public Student getStudentById(Integer id) {
        SqlSession sqlSession =MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void insertStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.commit();
        }
    }

    public int getCountOfStudent() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getCountOfStudent();
        } finally {
            sqlSession.close();
        }
    }

    public List<Student> getStudentForPage(int getStart, int getEnd) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentForPage(getStart, getEnd);
        } finally {
            sqlSession.close();
        }
    }
}
