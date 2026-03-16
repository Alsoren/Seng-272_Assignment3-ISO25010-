import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {

    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        ArrayList<SWSystem> webSystems = new ArrayList<>();
        webSystems.add(createECommercePlatform());
        webSystems.add(createBankingPortal());
        map.put("Web", webSystems);

        ArrayList<SWSystem> mobileSystems = new ArrayList<>();
        mobileSystems.add(createHealthApp());
        map.put("Mobile", mobileSystems);

        return map;
    }

    private static SWSystem createECommercePlatform() {
        SWSystem system = new SWSystem("ShopSphere", "Web", "3.2.1");

        QualityDimension functionalSuitability =
                new QualityDimension("Functional Suitability", "QC.FS", 25);

        functionalSuitability.addCriterion(
                new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        functionalSuitability.addCriterion(
                new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));

        system.addDimension(functionalSuitability);

        QualityDimension reliability =
                new QualityDimension("Reliability", "QC.RE", 25);

        reliability.addCriterion(
                new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
        reliability.addCriterion(
                new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));

        system.addDimension(reliability);

        QualityDimension performanceEfficiency =
                new QualityDimension("Performance Efficiency", "QC.PE", 25);

        performanceEfficiency.addCriterion(
                new Criterion("Response Time", 50, "lower", 100, 500, "ms"));
        performanceEfficiency.addCriterion(
                new Criterion("CPU Utilisation Ratio", 50, "lower", 10, 80, "%"));

        system.addDimension(performanceEfficiency);

        QualityDimension maintainability =
                new QualityDimension("Maintainability", "QC.MA", 25);

        maintainability.addCriterion(
                new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(
                new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 1, 15, "score"));

        system.addDimension(maintainability);

        return system;
    }

    private static SWSystem createBankingPortal() {
        SWSystem system = new SWSystem("SecureBank", "Web", "2.4.0");

        QualityDimension reliability =
                new QualityDimension("Reliability", "QC.RE", 30);

        reliability.addCriterion(
                new Criterion("Availability Ratio", 60, "higher", 95, 100, "%"));
        reliability.addCriterion(
                new Criterion("Defect Density", 40, "lower", 0, 20, "defect/KLOC"));

        system.addDimension(reliability);

        QualityDimension security =
                new QualityDimension("Security", "QC.SE", 40);

        security.addCriterion(
                new Criterion("Security Test Coverage", 50, "higher", 0, 100, "%"));
        security.addCriterion(
                new Criterion("Vulnerability Count", 50, "lower", 0, 20, "count"));

        system.addDimension(security);

        QualityDimension maintainability =
                new QualityDimension("Maintainability", "QC.MA", 30);

        maintainability.addCriterion(
                new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(
                new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 1, 15, "score"));

        system.addDimension(maintainability);

        return system;
    }

    private static SWSystem createHealthApp() {
        SWSystem system = new SWSystem("MediTrack", "Mobile", "1.8.2");

        QualityDimension usability =
                new QualityDimension("Usability", "QC.US", 35);

        usability.addCriterion(
                new Criterion("Task Completion Rate", 50, "higher", 0, 100, "%"));
        usability.addCriterion(
                new Criterion("User Error Rate", 50, "lower", 0, 50, "%"));

        system.addDimension(usability);

        QualityDimension performanceEfficiency =
                new QualityDimension("Performance Efficiency", "QC.PE", 35);

        performanceEfficiency.addCriterion(
                new Criterion("Response Time", 50, "lower", 100, 500, "ms"));
        performanceEfficiency.addCriterion(
                new Criterion("CPU Utilisation Ratio", 50, "lower", 10, 80, "%"));

        system.addDimension(performanceEfficiency);

        QualityDimension maintainability =
                new QualityDimension("Maintainability", "QC.MA", 30);

        maintainability.addCriterion(
                new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(
                new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 1, 15, "score"));

        system.addDimension(maintainability);

        return system;
    }
}