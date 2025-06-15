package com.testcase.generator.service;

import com.testcase.generator.model.TestStep;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthcareTestCaseTemplate implements IndustryTestCaseTemplate {
    
    @Override
    public String generateTitle(String useCase) {
        if (useCase.toLowerCase().contains("patient notes") || 
            useCase.toLowerCase().contains("post intake") ||
            useCase.toLowerCase().contains("progress notes")) {
            return "Healthcare EHR Test: Patient Progress Notes Documentation & Storage";
        }
        return "Healthcare System Test: Validate " + useCase + " Process";
    }
    
    @Override
    public String generateDescription(String useCase) {
        if (useCase.toLowerCase().contains("patient notes") || 
            useCase.toLowerCase().contains("post intake") ||
            useCase.toLowerCase().contains("progress notes")) {
            return "This test validates patient progress notes documentation and storage functionality in the Electronic Health Record (EHR) system. " +
                   "Ensures proper clinical documentation workflow, HIPAA compliance, data integrity, continuity of care tracking, " +
                   "and seamless integration with existing patient records and care plans.";
        }
        return "This test ensures the " + useCase + " functionality meets healthcare standards, " +
               "maintains patient data privacy (HIPAA compliance), and integrates properly with clinical workflows.";
    }
    
    @Override
    public String generatePreconditions(String useCase) {
        if (useCase.toLowerCase().contains("patient notes") || 
            useCase.toLowerCase().contains("post intake") ||
            useCase.toLowerCase().contains("progress notes")) {
            return "1. Healthcare provider has valid EHR system access with clinical documentation privileges\n" +
                   "2. Patient record exists with active care plan and previous notes\n" +
                   "3. EHR system is operational with real-time synchronization enabled\n" +
                   "4. HIPAA compliance modules and audit logging are fully active\n" +
                   "5. Patient consent forms for documentation and information sharing are current\n" +
                   "6. Clinical note templates and standardized formats are properly configured\n" +
                   "7. Provider has appropriate role-based permissions for patient chart access and modification\n" +
                   "8. Previous progress notes and care history are accessible for reference";
        }
        return "1. Healthcare provider has valid system access\n" +
               "2. Patient records are accessible\n" +
               "3. HIPAA compliance measures are active\n" +
               "4. Medical devices/systems are connected\n" +
               "5. Emergency protocols are in place";
    }
    
    @Override
    public List<TestStep> generateTestSteps(String useCase) {
        if (useCase.toLowerCase().contains("patient notes") || 
            useCase.toLowerCase().contains("post intake") ||
            useCase.toLowerCase().contains("progress notes")) {
            List<TestStep> steps = new ArrayList<>();
            steps.add(new TestStep(1, "Login to EHR system with authorized healthcare provider credentials", "Successful authentication with provider dashboard and assigned patients displayed"));
            steps.add(new TestStep(2, "Search and access patient record using Patient ID/MRN or patient name", "Patient chart opens showing current status, alerts, and recent activity timeline"));
            steps.add(new TestStep(3, "Review patient's medical history and previous progress notes", "Complete patient timeline visible with chronological notes and care interventions"));
            steps.add(new TestStep(4, "Navigate to Progress Notes or Clinical Documentation section", "Notes interface loads with available templates, previous entries, and formatting tools"));
            steps.add(new TestStep(5, "Create new progress note entry with appropriate date/time stamp", "Note creation dialog opens with auto-populated provider info and current timestamp"));
            steps.add(new TestStep(6, "Select appropriate note type (Nursing, Physician, Therapy, etc.)", "Note template loads with relevant fields and structured format for selected discipline"));
            steps.add(new TestStep(7, "Document patient's current condition and assessment findings", "Text entry accepted with spell-check, auto-save, and clinical terminology suggestions"));
            steps.add(new TestStep(8, "Record vital signs, measurements, and objective observations", "Structured data fields populate with validation for normal ranges and critical values"));
            steps.add(new TestStep(9, "Document patient's response to treatments and interventions", "Treatment response section captures medication effects, therapy outcomes, and patient feedback"));
            steps.add(new TestStep(10, "Update care plan goals and modify treatment orders if needed", "Care plan interface allows goal modification with reasoning and provider authorization"));
            steps.add(new TestStep(11, "Add relevant medical codes (ICD-10, CPT) and update problem list", "Medical coding system validates entries and automatically updates active problem list"));
            steps.add(new TestStep(12, "Attach supporting documents, images, or lab results", "File attachment successful with proper categorization, metadata, and security encryption"));
            steps.add(new TestStep(13, "Set note priority level and flag for follow-up if required", "Priority settings applied with automatic notification system for urgent items"));
            steps.add(new TestStep(14, "Review note content for accuracy and completeness", "Note preview displays formatted content with all sections properly completed"));
            steps.add(new TestStep(15, "Apply electronic signature and finalize the progress note", "Digital signature applied with timestamp, IP logging, and note status changed to 'Final'"));
            steps.add(new TestStep(16, "Verify note integration with patient timeline and care continuity", "Progress note appears in chronological order with proper categorization and searchability"));
            steps.add(new TestStep(17, "Test note sharing and communication with care team members", "Note accessible to authorized team members with appropriate role-based viewing permissions"));
            steps.add(new TestStep(18, "Generate progress summary report for care coordination", "Clinical summary generated including recent progress notes and care plan updates"));
            steps.add(new TestStep(19, "Validate comprehensive audit trail and compliance logging", "All documentation actions logged with provider ID, timestamp, IP address, and session details"));
            steps.add(new TestStep(20, "Secure logout with automatic chart closure and session termination", "Session ended securely with final audit log entry and automatic screen lock"));
            return steps;
        }
        
        List<TestStep> steps = new ArrayList<>();
        steps.add(new TestStep(1, "Login with healthcare provider credentials", "Secure access granted to authorized personnel"));
        steps.add(new TestStep(2, "Access patient information system", "Patient data loads with privacy controls"));
        steps.add(new TestStep(3, "Verify patient identity and medical history", "Correct patient profile displayed"));
        steps.add(new TestStep(4, "Execute " + useCase + " procedure", "Clinical process completed according to protocols"));
        steps.add(new TestStep(5, "Document results in patient record", "Medical data recorded with timestamp and provider ID"));
        steps.add(new TestStep(6, "Generate required reports/notifications", "Compliance reports generated automatically"));
        steps.add(new TestStep(7, "Secure logout and data protection", "Session ended with audit trail maintained"));
        return steps;
    }
    
    @Override
    public String generateExpectedResult(String useCase) {
        if (useCase.toLowerCase().contains("patient notes") || 
            useCase.toLowerCase().contains("post intake") ||
            useCase.toLowerCase().contains("progress notes")) {
            return "Patient progress notes should be successfully documented and stored in the EHR system with complete audit trail, " +
                   "proper clinical formatting and terminology, HIPAA compliance fully maintained, seamless integration with patient care timeline, " +
                   "care team accessibility with appropriate permissions, automated care plan updates, and all healthcare documentation " +
                   "standards and regulatory requirements satisfied for continuity of care and legal compliance.";
        }
        return "Healthcare " + useCase + " should be completed successfully with full audit trail, " +
               "patient privacy maintained, clinical documentation updated, and all regulatory requirements met.";
    }
}