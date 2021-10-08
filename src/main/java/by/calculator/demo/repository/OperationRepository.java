package by.calculator.demo.repository;

import by.calculator.demo.dao.OperationDAO;
import by.calculator.demo.domain.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OperationRepository {
    private List<Operation> operations = new ArrayList<>();

    private final OperationDAO operationDAO;

    public Operation saveOperation(String operationName, double argFirst, double argSecond, double result) {
        Operation newOperation = new Operation(operationName, argFirst, argSecond, result);
        operations.add(newOperation);
        return newOperation;
    }
}
