package by.calculator.demo.service;

import by.calculator.demo.dao.OperationDAO;
import by.calculator.demo.domain.Operation;
import by.calculator.demo.repository.OperationRepository;
import by.calculator.demo.util.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OperationService {
    private final OperationRepository operationRepository;
    private final OperationDAO operationDAO;

    public double addAndSave(double a, double b) {
        Operation operation = new Operation();
        double result = Calculator.add(a, b);
        operation.setId(1);
        operation.setOperationName("addition");
        operation.setArgFirst(a);
        operation.setArgSecond(b);
        operation.setResult(result);
        operationDAO.addOperation(operation);
        return result;
    }

    public double multiplyAndSave(double a, double b) {
        double result = Calculator.multiply(a, b);
        operationRepository.saveOperation("multiplication", a, b, result);    //todo operationName => ENUM
        return result;
    }

    public double subtractAndSave(double a, double b) {
        double result = Calculator.subtract(a, b);
        operationRepository.saveOperation("subtraction", a, b, result);    //todo operationName => ENUM
        return result;
    }

    public double divideAndSave(double a, double b) {
        double result = Calculator.divide(a, b);
        operationRepository.saveOperation("division", a, b, result);    //todo operationName => ENUM
        return result;
    }
}
