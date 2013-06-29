package fragsoft.exposure.service;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExposureValueDto implements Serializable {

    private String label;
    private BigDecimal value;
    private Integer index;

    public ExposureValueDto() {
    }

    public ExposureValueDto(String label) {
        this.label = label;
    }

    public ExposureValueDto(String label, BigDecimal value) {
        this(label);
        this.value = value;
    }

    public ExposureValueDto(String label, BigDecimal value, Integer index) {
        this(label, value);
        this.index = index;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

}
