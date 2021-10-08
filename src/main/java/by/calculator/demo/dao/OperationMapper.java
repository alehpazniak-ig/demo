package by.calculator.demo.dao;

import by.calculator.demo.domain.Operation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationMapper implements RowMapper<Operation> {

    @Override
    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Operation operation = new Operation();

        operation.setId(rs.getLong("id"));
        operation.setOperationName(rs.getString("operationName"));
        operation.setArgFirst(rs.getDouble("argFirst"));
        operation.setArgSecond(rs.getDouble("argSecond"));
        operation.setResult(rs.getDouble("result"));
        return operation;
    }
}
