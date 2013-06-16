package fragsoft.exposure.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApertureDto {

    private String label;

    public ApertureDto() {
    }

    public ApertureDto(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
