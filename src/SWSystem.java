import java.util.ArrayList;

public class SWSystem {
    private String systemName;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String systemName, String category, String version) {
        this.systemName = systemName;
        this.category = category;
        this.version = version;
        this.dimensions = new ArrayList<>();
    }

    public String getSystemName() {
        return systemName;
    }

    public String getCategory() {
        return category;
    }

    public String getVersion() {
        return version;
    }

    public ArrayList<QualityDimension> getDimensions() {
        return dimensions;
    }

    public void addDimension(QualityDimension dimension) {
        dimensions.add(dimension);
    }

    public double calculateOverallScore() {
        double weightedSum = 0.0;
        double totalWeight = 0.0;

        for (QualityDimension dimension : dimensions) {
            weightedSum += dimension.calculateDimensionScore() * dimension.getWeight();
            totalWeight += dimension.getWeight();
        }

        if (totalWeight == 0) {
            return 0.0;
        }

        return Math.round((weightedSum / totalWeight) * 10.0) / 10.0;
    }

    public QualityDimension findWeakestDimension() {
        if (dimensions.isEmpty()) {
            return null;
        }

        QualityDimension weakest = dimensions.get(0);

        for (QualityDimension dimension : dimensions) {
            if (dimension.calculateDimensionScore() < weakest.calculateDimensionScore()) {
                weakest = dimension;
            }
        }

        return weakest;
    }

    public String getOverallQualityLabel() {
        double score = calculateOverallScore();

        if (score >= 4.5) {
            return "Excellent Quality";
        } else if (score >= 3.5) {
            return "Good Quality";
        } else if (score >= 2.5) {
            return "Needs Improvement";
        } else {
            return "Poor Quality";
        }
    }

    public void printReport() {
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + systemName + " v" + version + " (" + category + ")");
        System.out.println("========================================");
        System.out.println();

        for (QualityDimension dimension : dimensions) {
            System.out.println("--- " + dimension.getName() + " [" + dimension.getIsoCode() + "] (Weight: " + dimension.getWeight() + ") ---");

            for (Criterion criterion : dimension.getCriteria()) {
                System.out.println(criterion);
            }

            System.out.println(">> Dimension Score: " + dimension.calculateDimensionScore()
                    + "/5 [" + dimension.getQualityLabel() + "]");
            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("OVERALL QUALITY SCORE: " + calculateOverallScore()
                + "/5 [" + getOverallQualityLabel() + "]");
        System.out.println("========================================");
        System.out.println();

        QualityDimension weakest = findWeakestDimension();

        if (weakest != null) {
            System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
            System.out.println("========================================");
            System.out.println("Weakest Characteristic : " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
            System.out.println("Score: " + weakest.calculateDimensionScore() + "/5  |  Gap: " + weakest.getGap());
            System.out.println("Level: " + weakest.getQualityLabel());
            System.out.println(">> This characteristic requires the most improvement.");
            System.out.println("========================================");
        }
    }
}
