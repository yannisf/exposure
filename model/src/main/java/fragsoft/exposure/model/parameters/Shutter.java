package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;

import java.util.List;

public class Shutter extends ExposureParameter {

    public static final ExposureParameterType TYPE = ExposureParameterType.SHUTTER;

    public Shutter(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Shutter(String label) throws NoMatchException {
        super(label);
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
