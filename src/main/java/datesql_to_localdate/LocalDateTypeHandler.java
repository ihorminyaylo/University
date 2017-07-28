package datesql_to_localdate;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LocalDate localDate, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public LocalDate getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
