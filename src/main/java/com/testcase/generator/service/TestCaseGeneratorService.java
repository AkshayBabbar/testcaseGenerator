package com.testcase.generator.service;

import com.testcase.generator.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestCaseGeneratorService {
    
    private final Map<IndustryType, IndustryTestCaseTemplate> industryTemplates;
    
    public TestCaseGeneratorService() {
        this.industryTemplates = initializeIndustryTemplates();
    }
    
    public TestCase generateTestCase(UseCaseRequest request) {
        TestCase testCase = new TestCase();
        testCase.setTestCaseId(generateTestCaseId());
        testCase.setIndustry(request.getIndustry());
        testCase.setModule(request.getModule() != null ? request.getModule() : "General");
        testCase.setPriority(request.getPriority() != null ? request.getPriority() : "Medium");
        
        IndustryTestCaseTemplate template = industryTemplates.get(request.getIndustry());
        if (template != null) {
            testCase.setTitle(template.generateTitle(request.getUseCase()));
            testCase.setDescription(template.generateDescription(request.getUseCase()));
            testCase.setPreconditions(template.generatePreconditions(request.getUseCase()));
            testCase.setTestSteps(template.generateTestSteps(request.getUseCase()));
            testCase.setExpectedResult(template.generateExpectedResult(request.getUseCase()));
        } else {
            // Fallback for unsupported industries
            testCase.setTitle("Test Case: " + request.getUseCase());
            testCase.setDescription("Verify " + request.getUseCase() + " functionality");
            testCase.setPreconditions("System should be accessible and user should be logged in");
            testCase.setTestSteps(generateGenericTestSteps(request.getUseCase()));
            testCase.setExpectedResult("Use case should execute successfully");
        }
        
        return testCase;
    }
    
    private String generateTestCaseId() {
        return "TC_" + System.currentTimeMillis();
    }
    
    private List<TestStep> generateGenericTestSteps(String useCase) {
        List<TestStep> steps = new ArrayList<>();
        steps.add(new TestStep(1, "Navigate to the application", "Application loads successfully"));
        steps.add(new TestStep(2, "Execute: " + useCase, "Action completes without errors"));
        steps.add(new TestStep(3, "Verify the result", "Expected outcome is achieved"));
        return steps;
    }
    
    private Map<IndustryType, IndustryTestCaseTemplate> initializeIndustryTemplates() {
        Map<IndustryType, IndustryTestCaseTemplate> templates = new HashMap<>();
        templates.put(IndustryType.HEALTHCARE, new HealthcareTestCaseTemplate());
        return templates;
    }
}