package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExactMatchNotFoundException;
import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public abstract class ExposureParameter implements Comparator<BigDecimal> {

    private static final Logger LOG = LoggerFactory.getLogger(ExposureParameter.class);

    private Integer index;

    ExposureParameter() { }

    public ExposureParameter(int index) throws ExposureOutOfScaleException {
        if (index < 0 || getValues().size() < index) {
            throw new ExposureOutOfScaleException();
        }
        this.index = index;
    }

    public ExposureParameter(String label) throws NoMatchException, ExposureOutOfScaleException {
        try {
            findExposureValueFromLabel(label);
        } catch (ExactMatchNotFoundException emnf) {
            LOG.info("Exact match not found, switching to intelligent match");
            intelligentExposureValueFromLabel(label);
        }
    }

    public Integer getIndex() {
        return index;
    }

    public ExposureValue getValue() {
        return getValues().get(index);
    }

    void findExposureValueFromLabel(String label) throws ExactMatchNotFoundException {
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

    void intelligentExposureValueFromLabel(String label) throws NoMatchException, ExposureOutOfScaleException {
        String sanitized = dropNonNumericChars(label);
        LOG.info("Approximating {}[{}]", getSymbol(), sanitized);
        try {
            BigDecimal convertedValue = new BigDecimal(sanitized);
            if (convertedValue.compareTo(getRightLimit()) > 0   || convertedValue.compareTo(getLeftLimit()) < 0 ) {
                throw new ExposureOutOfScaleException();
            }
            ExposureValue optimal = findOptimalMatch(convertedValue);
            this.index = getValues().indexOf(optimal);
            LOG.debug("Approximation: {}[{}] => {}[{}]", getSymbol(), label, getSymbol(), getValue().getValue());
        } catch (NumberFormatException | NullPointerException ex) {
            throw new NoMatchException(ex);
        }
    }

    ExposureValue findOptimalMatch(BigDecimal convertedValue) {
        ExposureValue optimal = null;
        BigDecimal minimumValueDifference = null;

        for (ExposureValue value : getValues()) {
            BigDecimal valueDifference = convertedValue.subtract(value.getValue());
            if (minimumValueDifference == null || minimumValueDifference.compareTo(valueDifference.abs()) > 0) {
                LOG.debug("Setting new minimum value difference to {}", valueDifference);
                minimumValueDifference = valueDifference;
                optimal = value;
            }
        }

        return optimal;
    }

    static String dropNonNumericChars(String label) {
        String sanitized = label.replaceAll("[^\\d.]", "");
        if (!label.equals(sanitized)) {
            LOG.info("Dropped non-numeric characters: {} => {}", label, sanitized);
        }

        return sanitized;
    }

    @Override
    public String toString() {
        return getValue().getType() + "[" + getValue().getLabel() + "]";
    }

    @Override
    public int compare(BigDecimal o1, BigDecimal o2) {
        return o1.compareTo(o2);
    }

    abstract public BigDecimal getLeftLimit();

    abstract public BigDecimal getRightLimit();

    abstract public String getSymbol();

    abstract protected List<ExposureValue> getValues();

    abstract public ExposureParameter displaceBy(Integer displacement) throws ExposureOutOfScaleException, NoMatchException;

}
