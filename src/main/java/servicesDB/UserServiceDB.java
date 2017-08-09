package servicesDB;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;

public class UserServiceDB {
    public User getUser(String name, String password) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUser(name, password);
        } finally {
            sqlSession.close();
        }
    }
}
