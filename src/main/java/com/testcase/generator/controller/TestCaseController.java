package com.testcase.generator.controller;

import com.testcase.generator.model.*;
import com.testcase.generator.service.TestCaseGeneratorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/testcase")
@CrossOrigin(origins = "*")
public class TestCaseController {
    
    @Autowired
    private TestCaseGeneratorService testCaseGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<TestCase> generateTestCase(
            @Valid @RequestBody UseCaseRequest request,
            HttpServletRequest httpRequest) {

        System.out.println("Method: " + httpRequest.getMethod());
        System.out.println("URL: " + httpRequest.getRequestURL());
        System.out.println("Headers: " + Collections.list(httpRequest.getHeaderNames()));

        TestCase testCase = testCaseGeneratorService.generateTestCase(request);
        return ResponseEntity.ok(testCase);
    }
    
    @GetMapping("/industries")
    public ResponseEntity<List<IndustryInfo>> getAvailableIndustries() {
        List<IndustryInfo> industries = Arrays.stream(IndustryType.values())
                .map(industry -> new IndustryInfo(industry.name(), industry.getDisplayName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(industries);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Test Case Generator Service is running!");
    }
    
    // Inner class for industry information
    public static class IndustryInfo {
        private String code;
        private String name;
        
        public IndustryInfo(String code, String name) {
            this.code = code;
            this.name = name;
        }
        
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
