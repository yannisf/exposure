package fragsoft.exposure;

import java.util.*;

public abstract class ExposureParameter {

    private Integer index;
    private ExposureValue value;

    public ExposureParameter(String label) {
        findExposureValueFromLabel(label);
    }

    public Integer getIndex() {
        return index;
    }

    public ExposureValue getValue() {
        return value;
    }

    private void findExposureValueFromLabel(String label) {
        for (ExposureValue value : getValues()) {
            if (value.getLabel().equals(label)) {
                this.value = value;
                this.index = getValues().indexOf(value);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return  value.getType() + "[" + value.getLabel() + "]";
    }

    abstract protected List<ExposureValue> getValues();

    abstract public ExposureParameter displaceBy(Integer displacement);
}
