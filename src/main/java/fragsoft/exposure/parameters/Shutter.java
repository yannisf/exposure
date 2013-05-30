package fragsoft.exposure.parameters;

import fragsoft.exposure.parameters.ExposureValue.*;
import fragsoft.exposure.exception.*;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Shutter extends ExposureParameter {

    private static final List<ExposureValue> VALUES = new ArrayList<ExposureValue>();

    static {
        VALUES.add(new ExposureValue("1/8000", new BigDecimal(0.000125), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/6400", new BigDecimal(0.00015625), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5000", new BigDecimal(0.0002), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4000", new BigDecimal(0.00025), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/3200", new BigDecimal(0.0003125), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2500", new BigDecimal(0.0004), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2000", new BigDecimal(0.0005), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/1600", new BigDecimal(0.000625), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1250", new BigDecimal(0.0008), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1000", new BigDecimal(0.001), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/800", new BigDecimal(0.00125), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/640", new BigDecimal(0.0015625), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/500", new BigDecimal(0.002), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/400", new BigDecimal(0.0025), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/320", new BigDecimal(0.003125), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/250", new BigDecimal(0.004), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/200", new BigDecimal(0.005), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/160", new BigDecimal(0.00625), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/125", new BigDecimal(0.008), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/100", new BigDecimal(0.01), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/80", new BigDecimal(0.0125), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/60", new BigDecimal(0.0167), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/50", new BigDecimal(0.02), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/40", new BigDecimal(0.025), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/30", new BigDecimal(0.033), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/25", new BigDecimal(0.04), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/20", new BigDecimal(0.05), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/15", new BigDecimal(0.067), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/13", new BigDecimal(0.077), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/10", new BigDecimal(0.1), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/8", new BigDecimal(0.125), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/6", new BigDecimal(0.167), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5", new BigDecimal(0.2), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4", new BigDecimal(0.25), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/3", new BigDecimal(0.333), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2.5", new BigDecimal(0.4), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2", new BigDecimal(0.5), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1/1.6", new BigDecimal(0.625), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1.3", new BigDecimal(0.769), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1", new BigDecimal(1), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("1.3", new BigDecimal(1.6), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1.6", new BigDecimal(1.6), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("2", new BigDecimal(2), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("2.5", new BigDecimal(2.5), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("3", new BigDecimal(3), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("4", new BigDecimal(4), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("5", new BigDecimal(5), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("6", new BigDecimal(6), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("8", new BigDecimal(8), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("10", new BigDecimal(10), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("13", new BigDecimal(13), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("15", new BigDecimal(15), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("20", new BigDecimal(20), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("25", new BigDecimal(25), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("30", new BigDecimal(30), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("40", new BigDecimal(40), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("50", new BigDecimal(50), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("60", new BigDecimal(60), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("80", new BigDecimal(80), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("100", new BigDecimal(100), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("120", new BigDecimal(120), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("160", new BigDecimal(160), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("200", new BigDecimal(200), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("240", new BigDecimal(240), Type.SHUTTER, Granularity.FULL));
        VALUES.add(new ExposureValue("320", new BigDecimal(320), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("400", new BigDecimal(400), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("480", new BigDecimal(480), Type.SHUTTER, Granularity.FULL));
    }

    public Shutter(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Shutter(String label) throws NoMatchException {
        super(label);
    }

    @Override
    protected List<ExposureValue> getValues() {
        return VALUES;
    }

    @Override
    public Shutter displaceBy(Integer displacement) throws ExposureOutOfScaleException{
        return new Shutter(getIndex() + displacement);
    }

    @Override
    void intelligentExposureValueFromLabel(String label) throws NoMatchException {
    }

}
