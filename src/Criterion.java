public class Criterion {
    private String metricName;
    private double weight;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;
    private double measuredValue;

    public Criterion(String metricName, double weight, String direction,
                     double minValue, double maxValue, String unit) {
        this.metricName = metricName;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.measuredValue = 0.0;
    }

    public String getMetricName() {
        return metricName;
    }

    public double getWeight() {
        return weight;
    }

    public String getDirection() {
        return direction;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public String getUnit() {
        return unit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public double calculateScore() {
        double score;

        if (direction.equalsIgnoreCase("higher")) { // burda ai büyük harfleri görmezden gelmem için bunu önerdi
            score = 1 + ((measuredValue - minValue) / (maxValue - minValue)) * 4;
        } else {
            score = 5 - ((measuredValue - minValue) / (maxValue - minValue)) * 4;
        }

        if (score < 1) score = 1;
        if (score > 5) score = 5;

        score = Math.round(score * 2.0) / 2.0; // 0 yada 0.5 er scorların oluşması için ödevde skorların sadece öyle olması gerektiği yazıyor
        return score;
    }

    @Override
    public String toString(){
        return metricName + ": " + measuredValue + " " + unit +
                " -> Score: " + calculateScore() +
                " (" + (direction.equalsIgnoreCase("higher") ? "Higher is better" : "Lower is better") + ")";
    }
}
