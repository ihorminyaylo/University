package mapper;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{name} AND password = #{password}")
    @Results({
            @Result(id = true, column = "id", property = "idUser"),
            @Result(column = "name", property = "nameUser"),
            @Result(column = "password", property = "password")
    })
    User getUser(@Param("name")String name, @Param("password")String password);
}
