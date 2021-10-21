package by.calculator.demo.service;

import by.calculator.demo.dao.IOperationDao;
import by.calculator.demo.domain.Operation;
import by.calculator.demo.util.Calculator;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    private final IOperationDao dao;

    public OperationService(IOperationDao operationDAO) {
        this.dao = operationDAO;
    }

    public Operation additionAndSave(double a, double b) {
        Operation operation = new Operation();
        double result = Calculator.add(a, b);
        operation.setOperationName("addition");
        operation.setArgFirst(a);
        operation.setArgSecond(b);
        operation.setResult(result);
        dao.save(operation);
        return operation;
    }

    public Operation multiplyAndSave(double a, double b) {
        Operation operation = new Operation();
        double result = Calculator.multiply(a, b);
        operation.setOperationName("multiply");
        operation.setArgFirst(a);
        operation.setArgSecond(b);
        operation.setResult(result);
        dao.save(operation);
        return operation;
    }

    public Operation subtractAndSave(double a, double b) {
        Operation operation = new Operation();
        double result = Calculator.subtract(a, b);
        operation.setOperationName("subtract");
        operation.setArgFirst(a);
        operation.setArgSecond(b);
        operation.setResult(result);
        dao.save(operation);
        return operation;
    }

    public Operation divideAndSave(double a, double b) {
        Operation operation = new Operation();
        double result = Calculator.divide(a, b);
        operation.setOperationName("divide");
        operation.setArgFirst(a);
        operation.setArgSecond(b);
        operation.setResult(result);
        dao.save(operation);
        return operation;
    }
}
