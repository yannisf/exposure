package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue.ExposureParameterType;

import java.math.BigDecimal;
import java.util.List;

public class Shutter extends ExposureParameter {

    public static final ExposureParameterType TYPE = ExposureValue.ExposureParameterType.SHUTTER;
    public static final BigDecimal LEFT_LIMIT = new BigDecimal("0.0001");
    public static final BigDecimal RIGHT_LIMIT = new BigDecimal("500");

    Shutter() { }

    public Shutter(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Shutter(String label) throws NoMatchException, ExposureOutOfScaleException {
        super(label);
    }

    @Override
    public BigDecimal getLeftLimit() {
        return LEFT_LIMIT;
    }

    @Override
    public BigDecimal getRightLimit() {
        return RIGHT_LIMIT;
    }

    @Override
    public String getSymbol() {
        return TYPE.getSymbol();
    }

    @Override
    protected List<ExposureValue> getValues() {
        return ValuesStore.getShutterValues();
    }

    @Override
    public Shutter displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Shutter(displacedIndex);
    }

}
