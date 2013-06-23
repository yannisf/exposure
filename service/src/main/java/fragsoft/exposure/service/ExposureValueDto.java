package fragsoft.exposure.service;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExposureValueDto implements Serializable {

    private String label;

    private BigDecimal value;

    public ExposureValueDto() {
    }

    public ExposureValueDto(String label) {
        this.label = label;
    }

    public ExposureValueDto(String label, BigDecimal value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
