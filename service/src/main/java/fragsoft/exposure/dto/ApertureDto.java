package fragsoft.exposure.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class ApertureDto {

    private Integer index;
    private String label;
    private BigDecimal value;

    public ApertureDto() {
    }

    public ApertureDto(Integer index, String label, BigDecimal value) {
        this.index = index;
        this.label = label;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
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

}
