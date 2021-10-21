package by.calculator.demo.dao;

import by.calculator.demo.domain.Operation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NamedParamJdbcTemplateOperationDAOTest {

    @Autowired
    @Qualifier(value = "namedParameterJdbcTemplate")
    IOperationDao operationDao;

    @Test
    void testMethodSave() {
        Operation operation = new Operation();

        operation.setOperationName("addition");
        operation.setArgFirst(5.5);
        operation.setArgSecond(3.1);
        operation.setResult(8.6);

        operationDao.save(operation);
    }
}