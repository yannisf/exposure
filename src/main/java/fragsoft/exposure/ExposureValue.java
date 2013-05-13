package fragsoft.exposure;

import java.math.BigDecimal;

public class ExposureValue {

    public enum Type {
        ISO,
        APERTURE,
        SHUTTER
    }

    public enum Granularity {
        FULL,
        THIRD
    }

    private String label;
    private BigDecimal value;
    private Type type;
    private Granularity granularity;

    public ExposureValue(String label, BigDecimal value, Type type, Granularity granularity) {
        this.label = label;
        this.value = value;
        this.type = type;
        this.granularity = granularity;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    @Override
    public String toString() {
        return "EV: " + type + "," + label + "," + getGranularity();
    }

}
