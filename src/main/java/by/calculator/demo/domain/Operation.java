package by.calculator.demo.domain;


public class Operation {

    private long id;

    private String operationName;
    private double argFirst;
    private double argSecond;
    private double result;

    public Operation() {
    }

    public Operation(String operationName, double argFirst, double argSecond, double result) {
        this.operationName = operationName;
        this.argFirst = argFirst;
        this.argSecond = argSecond;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public double getArgFirst() {
        return argFirst;
    }

    public void setArgFirst(double argFirst) {
        this.argFirst = argFirst;
    }

    public double getArgSecond() {
        return argSecond;
    }

    public void setArgSecond(double argSecond) {
        this.argSecond = argSecond;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
