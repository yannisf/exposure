package fragsoft.exposure.parameters;

import fragsoft.exposure.exception.*;

import java.math.*;
import java.util.*;

public abstract class ExposureParameter implements Comparator<BigDecimal> {

    private Integer index;

    public ExposureParameter(int index) throws ExposureOutOfScaleException {
        if (index < 0 || getValues().size() < index) {
            throw new ExposureOutOfScaleException();
        }
        this.index = index;
    }

    public ExposureParameter(String label) throws NoMatchException {
        try {
            findExposureValueFromLabel(label);
        } catch (ExactMatchNotFoundException emnf) {
            System.out.println("Exact match not found, switching to intelligent (approximate) match");
            intelligentExposureValueFromLabel(label);
        }
    }


    public Integer getIndex() {
        return index;
    }

    public ExposureValue getValue() {
        return getValues().get(index);
    }

    private void findExposureValueFromLabel(String label) throws ExactMatchNotFoundException {
        for (ExposureValue value : getValues()) {
            if (value.getLabel().equals(label)) {
                this.index = getValues().indexOf(value);
                break;
            }
        }

        if (this.index == null) {
            throw new ExactMatchNotFoundException();
        }
    }

    @Override
    public String toString() {
        return  getValue().getType() + "[" + getValue().getLabel() + "]";
    }

    @Override
    public int compare(BigDecimal o1, BigDecimal o2) {
        return o1.compareTo(o2);
    }

    abstract protected List<ExposureValue> getValues();

    abstract public ExposureParameter displaceBy(Integer displacement) throws ExposureOutOfScaleException, NoMatchException;

    abstract void intelligentExposureValueFromLabel(String label) throws NoMatchException;

}
