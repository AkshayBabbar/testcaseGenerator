package com.testcase.generator.model;

import java.time.LocalDateTime;
import java.util.List;

public class TestCase {
    private String testCaseId;
    private String title;
    private String description;
    private String preconditions;
    private List<TestStep> testSteps;
    private String expectedResult;
    private String priority;
    private String module;
    private IndustryType industry;
    private LocalDateTime createdAt;
    
    public TestCase() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public String getTestCaseId() { return testCaseId; }
    public void setTestCaseId(String testCaseId) { this.testCaseId = testCaseId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getPreconditions() { return preconditions; }
    public void setPreconditions(String preconditions) { this.preconditions = preconditions; }
    
    public List<TestStep> getTestSteps() { return testSteps; }
    public void setTestSteps(List<TestStep> testSteps) { this.testSteps = testSteps; }
    
    public String getExpectedResult() { return expectedResult; }
    public void setExpectedResult(String expectedResult) { this.expectedResult = expectedResult; }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    
    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }
    
    public IndustryType getIndustry() { return industry; }
    public void setIndustry(IndustryType industry) { this.industry = industry; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}