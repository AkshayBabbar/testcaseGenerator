package com.testcase.generator.service;

import com.testcase.generator.model.TestStep;
import java.util.List;

public interface IndustryTestCaseTemplate {
    String generateTitle(String useCase);
    String generateDescription(String useCase);
    String generatePreconditions(String useCase);
    List<TestStep> generateTestSteps(String useCase);
    String generateExpectedResult(String useCase);
}