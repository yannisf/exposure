package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue.ExposureParameterType;

import java.math.BigDecimal;
import java.util.List;

public class Iso extends ExposureParameter {

    public static final ExposureParameterType TYPE = ExposureValue.ExposureParameterType.ISO;
    public static final BigDecimal LEFT_LIMIT = new BigDecimal("20");
    public static final BigDecimal RIGHT_LIMIT = new BigDecimal("30000");


    public Iso(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Iso(String label) throws NoMatchException, ExposureOutOfScaleException {
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
        return ValuesStore.getIsoValues();
    }

    @Override
    public Iso displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Iso(displacedIndex);
    }

}
