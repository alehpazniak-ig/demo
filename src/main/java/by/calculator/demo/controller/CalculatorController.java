package by.calculator.demo.controller;

import by.calculator.demo.domain.Operation;
import by.calculator.demo.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/calculator/")
public class CalculatorController {
    private final OperationService operationService;

    @PostMapping("addition/{a}/{b}")
    public Operation additionNp(@PathVariable(value = "a") double a,
                                @PathVariable(value = "b") double b) {
        return operationService.additionAndSave(a, b);
    }


    @PostMapping(value = "/multiply/{a}/{b}")

    public Operation multiply(@PathVariable(value = "a") double a,
                           @PathVariable(value = "b") double b) {
        return operationService.multiplyAndSave(a, b);
    }

    @PostMapping(value = "/divide/{a}/{b}")
    public Operation divide(@PathVariable(value = "a") double a,
                         @PathVariable(value = "b") double b) {
        return operationService.divideAndSave(a, b);
    }

    @PostMapping(value = "/subtract/{a}/{b}")
    public Operation subtract(@PathVariable(value = "a") double a,
                           @PathVariable(value = "b") double b) {
        return operationService.subtractAndSave(a, b);
    }

}
