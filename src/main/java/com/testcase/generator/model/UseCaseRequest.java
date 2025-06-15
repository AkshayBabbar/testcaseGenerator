package com.testcase.generator.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UseCaseRequest {
    @NotBlank(message = "Use case description is required")
    private String useCase;
    
    @NotNull(message = "Industry type is required")
    private IndustryType industry;
    
    private String module;
    private String priority;
    
    public UseCaseRequest() {}
    
    public UseCaseRequest(String useCase, IndustryType industry, String module, String priority) {
        this.useCase = useCase;
        this.industry = industry;
        this.module = module;
        this.priority = priority;
    }
    
    // Getters and Setters
    public String getUseCase() { return useCase; }
    public void setUseCase(String useCase) { this.useCase = useCase; }
    
    public IndustryType getIndustry() { return industry; }
    public void setIndustry(IndustryType industry) { this.industry = industry; }
    
    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}