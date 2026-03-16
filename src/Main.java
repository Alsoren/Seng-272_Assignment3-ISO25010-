import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();

        ArrayList<SWSystem> webSystems = allSystems.get("Web");

        if (webSystems == null) {
            System.out.println("Web category not found.");
            return;
        }

        SWSystem shopSphere = null;

        for (SWSystem system : webSystems) {
            if (system.getSystemName().equalsIgnoreCase("ShopSphere")) {
                shopSphere = system;
                break;
            }
        }

        if (shopSphere == null) {
            System.out.println("ShopSphere system not found.");
            return;
        }

        for (QualityDimension dimension : shopSphere.getDimensions()) {
            if (dimension.getName().equalsIgnoreCase("Functional Suitability")) {
                for (Criterion criterion : dimension.getCriteria()) {
                    if (criterion.getMetricName().equalsIgnoreCase("Functional Completeness Ratio")) {
                        criterion.setMeasuredValue(94);
                    } else if (criterion.getMetricName().equalsIgnoreCase("Functional Correctness Ratio")) {
                        criterion.setMeasuredValue(91);
                    }
                }
            } else if (dimension.getName().equalsIgnoreCase("Reliability")) {
                for (Criterion criterion : dimension.getCriteria()) {
                    if (criterion.getMetricName().equalsIgnoreCase("Availability Ratio")) {
                        criterion.setMeasuredValue(99.2);
                    } else if (criterion.getMetricName().equalsIgnoreCase("Defect Density")) {
                        criterion.setMeasuredValue(2.1);
                    }
                }
            } else if (dimension.getName().equalsIgnoreCase("Performance Efficiency")) {
                for (Criterion criterion : dimension.getCriteria()) {
                    if (criterion.getMetricName().equalsIgnoreCase("Response Time")) {
                        criterion.setMeasuredValue(220);
                    } else if (criterion.getMetricName().equalsIgnoreCase("CPU Utilisation Ratio")) {
                        criterion.setMeasuredValue(38);
                    }
                }
            } else if (dimension.getName().equalsIgnoreCase("Maintainability")) {
                for (Criterion criterion : dimension.getCriteria()) {
                    if (criterion.getMetricName().equalsIgnoreCase("Test Coverage Ratio")) {
                        criterion.setMeasuredValue(72);
                    } else if (criterion.getMetricName().equalsIgnoreCase("Cyclomatic Complexity (avg)")) {
                        criterion.setMeasuredValue(8.5);
                    }
                }
            }
        }

        shopSphere.printReport();
    }
}