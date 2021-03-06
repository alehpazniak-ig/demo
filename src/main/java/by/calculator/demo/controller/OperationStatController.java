package by.calculator.demo.controller;

import by.calculator.demo.dao.OperationStatDao;
import by.calculator.demo.domain.CountOperation;
import by.calculator.demo.domain.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/stat")
public class OperationStatController {

    private final OperationStatDao operationStatDao;

    @GetMapping(value = "/last-operation")
    public Operation getLastOperation() {
        return operationStatDao.getLastOperation();
    }

    @GetMapping(value = "/count-operations-on-date/{date}")
    public List<CountOperation> getCountOperationsOnDate(
            @PathVariable(value = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return operationStatDao.getCountOperationsOnDate(date);
    }

    @GetMapping(value = "/count-operations-between-date/{begin}/{end}")
    public List<CountOperation> getCountOperationsBetweenDate(
            @PathVariable(value = "begin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date begin,
            @PathVariable(value = "end", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return operationStatDao.getCountOperationsBetweenDate(begin, end);
    }

    @GetMapping(value = "/most-popular-operations-between-date/{begin}/{end}")
    public List<CountOperation> getMostPopularOperationsBetweenDate(
            @PathVariable(value = "begin", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date begin,
            @PathVariable(value = "end", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return operationStatDao.getMostPopularOperationsBetweenDate(begin, end);
    }
}
