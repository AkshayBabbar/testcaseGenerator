package com.testcase.generator.model;

public enum IndustryType {
    BANKING("Banking & Finance"),
    HEALTHCARE("Healthcare"),
    ECOMMERCE("E-commerce"),
    EDUCATION("Education"),
    MANUFACTURING("Manufacturing"),
    RETAIL("Retail"),
    INSURANCE("Insurance"),
    TELECOMMUNICATIONS("Telecommunications"),
    REAL_ESTATE("Real Estate"),
    LOGISTICS("Logistics & Supply Chain");
    
    private final String displayName;
    
    IndustryType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}