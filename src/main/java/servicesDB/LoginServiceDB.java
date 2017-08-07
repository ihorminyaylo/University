package servicesDB;

import exception.InvalidFormatException;
import mapper.LoginMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AsusIT on 03.08.2017.
 */
public class LoginServiceDB {
    public void validateLoginName(String name) throws InvalidFormatException {
        String LOGIN_NAME_PATTERN = "[a-z]+[0-9]+";
        Pattern pSubjectName = Pattern.compile(LOGIN_NAME_PATTERN);
        Matcher matcher = pSubjectName.matcher(name);
        if (!matcher.matches()) {
            throw new InvalidFormatException("The name of login isn't correct");
        }
    }

    public void validateLoginPassword(String password) throws InvalidFormatException {
        String LOGIN_NAME_PATTERN = "[a-z]+[0-9]+";
        Pattern pSubjectName = Pattern.compile(LOGIN_NAME_PATTERN);
        Matcher matcher = pSubjectName.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidFormatException("The password isn't correct");
        }
    }

    public User enterUser(String name, String password) throws InvalidFormatException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            //validateLoginName(name);
            //validateLoginPassword(password);
            return loginMapper.enterUser(name, password);
        } finally {
            sqlSession.close();
        }
    }
}
