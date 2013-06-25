package fragsoft.exposure.model.parameters;

import java.math.BigDecimal;

public class ExposureValue {

    private final String label;
    private final BigDecimal value;
    private final ExposureParameterType type;
    private final ValuesStore.ValuesGranularity granularity;

    public ExposureValue(String label, BigDecimal value, ExposureParameterType type, ValuesStore.ValuesGranularity granularity) {
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

    public ExposureParameterType getType() {
        return type;
    }

    public ValuesStore.ValuesGranularity getGranularity() {
        return granularity;
    }

    @Override
    public String toString() {
        return "EV: " + type + "," + label + "," + getGranularity();
    }

    public static enum ExposureParameterType {
        ISO("ISO"),
        APERTURE("A"),
        SHUTTER("S");

        private String symbol;

        ExposureParameterType(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return this.symbol;
        }
    }

}
