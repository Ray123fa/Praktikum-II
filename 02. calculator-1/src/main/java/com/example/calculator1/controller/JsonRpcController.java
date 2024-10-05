package com.example.calculator1.controller;

import com.example.calculator1.rpc.JsonRpcResponse;
import com.example.calculator1.rpc.JsonRpcRequest;
import com.example.calculator1.service.CalculatorService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRpcController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody
                                                       JsonRpcRequest request) {
        JsonRpcResponse response = new JsonRpcResponse();

        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();

            double a = params.get("a").asDouble();
            double b = params.get("b").asDouble();
            double result;
            switch (method) {
                case "add":
                    result = calculatorService.add(a, b);
                    response.setResult(result);
                    break;
                case "subtract":
                    result = calculatorService.subtract(a, b);
                    response.setResult(result);
                    break;
                case "multiply":
                    result = calculatorService.multiply(a, b);
                    response.setResult(result);
                    break;
                case "divide":
                    result = calculatorService.divide(a, b);
                    response.setResult(result);
                    break;
                default:
                    return ResponseEntity.badRequest().build();
            }
            response.setId(request.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
