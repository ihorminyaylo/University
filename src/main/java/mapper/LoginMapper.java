package mapper;

import model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by AsusIT on 03.08.2017.
 */
public interface LoginMapper {
    @Select("SELECT * FROM users WHERE name = {#user} and password ={#password}")
    @Results({
            @Result(id = true, column = "id", property = "idUser"),
            @Result(column = "name", property = "nameUser"),
            @Result(column = "password", property = "password")
    })
    User enterUser(String user, String password);
}
