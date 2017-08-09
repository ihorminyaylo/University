package mapper;

import model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = 'test' AND password = 'test'")
    @Results({
            @Result(id = true, column = "id", property = "idUser"),
            @Result(column = "name", property = "nameUser"),
            @Result(column = "password", property = "password")
    })
    User getUser(String name, String password);
}
