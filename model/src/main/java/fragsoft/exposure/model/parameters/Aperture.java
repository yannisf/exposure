package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue.ExposureParameterType;

import java.util.List;

public class Aperture extends ExposureParameter {

    public static final ExposureParameterType TYPE = ExposureValue.ExposureParameterType.APERTURE;

    public Aperture(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Aperture(String label) throws NoMatchException {
        super(label);
    }

    @Override
    public String getSymbol() {
        return TYPE.getSymbol();
    }

    @Override
    protected List<ExposureValue> getValues() {
        return ValuesStore.getApertureValues();
    }

    @Override
    public Aperture displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Aperture(displacedIndex);
    }

}
