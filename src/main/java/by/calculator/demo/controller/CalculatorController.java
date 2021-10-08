package by.calculator.demo.controller;

import by.calculator.demo.dao.OperationDAO;
import by.calculator.demo.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/calculator/")
public class CalculatorController {
    private final OperationService operationService;
    private final OperationDAO operationDAO;

    @PostMapping("add/{a}/{b}")
    public double add(@PathVariable(value = "a") double a,
                       @PathVariable(value = "b") double b) {
        return operationService.addAndSave(a, b);
    }


    @PostMapping(value = "/multiply/{a}/{b}")

    public double multiply(@PathVariable(value = "a") double a,
                           @PathVariable(value = "b") double b) {
        return operationService.multiplyAndSave(a, b);
    }

    @GetMapping(value = "/divide/{a}/{b}")
    public double divide(@PathVariable(value = "a") double a,
                         @PathVariable(value = "b") double b) {
        return operationService.divideAndSave(a, b);
    }

    @PostMapping(value = "/subtract/{a}/{b}")
    public double subtract(@PathVariable(value = "a") double a,
                           @PathVariable(value = "b") double b) {
        return operationService.subtractAndSave(a, b);
    }

}
