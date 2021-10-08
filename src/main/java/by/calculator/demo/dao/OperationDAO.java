package by.calculator.demo.dao;

import by.calculator.demo.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class OperationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public OperationDAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("operation_log")
                .usingGeneratedKeyColumns("operation_log_id");
    }

    public void addOperation(Operation operation) {
        SimpleJdbcInsert simpleJdbcInsert =
                new SimpleJdbcInsert(jdbcTemplate).withTableName("operation_log");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ID", operation.getId());
        parameters.put("OPERATION_NAME", operation.getOperationName());
        parameters.put("ARG_FIRST", operation.getArgFirst());
        parameters.put("ARG_SECOND", operation.getArgSecond());
        parameters.put("RESULT", operation.getResult());

//        long generateId = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
//        operation.setId(generateId);

        simpleJdbcInsert.execute(parameters);
    }

    public void save(Operation operation) {
        jdbcTemplate.update("INSERT INTO operation_log VALUES(1, ?, ?, ?, ?)",
                operation.getOperationName(), operation.getArgFirst(), operation.getArgSecond(), operation.getResult());
    }
}