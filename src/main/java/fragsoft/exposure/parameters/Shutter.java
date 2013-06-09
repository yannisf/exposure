package fragsoft.exposure.parameters;

import fragsoft.exposure.exception.ExposureOutOfScaleException;
import fragsoft.exposure.exception.NoMatchException;
import fragsoft.exposure.parameters.ExposureValue.Granularity;
import fragsoft.exposure.parameters.ExposureValue.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shutter extends ExposureParameter {

    public static final Type TYPE = Type.SHUTTER;

    private static final List<ExposureValue> VALUES = new ArrayList<>();

    static {
        VALUES.add(new ExposureValue("1/8000", new BigDecimal(0.000125), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/6400", new BigDecimal(0.00015625), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5000", new BigDecimal(0.0002), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4000", new BigDecimal(0.00025), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/3200", new BigDecimal(0.0003125), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2500", new BigDecimal(0.0004), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2000", new BigDecimal(0.0005), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/1600", new BigDecimal(0.000625), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1250", new BigDecimal(0.0008), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1000", new BigDecimal(0.001), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/800", new BigDecimal(0.00125), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/640", new BigDecimal(0.0015625), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/500", new BigDecimal(0.002), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/400", new BigDecimal(0.0025), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/320", new BigDecimal(0.003125), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/250", new BigDecimal(0.004), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/200", new BigDecimal(0.005), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/160", new BigDecimal(0.00625), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/125", new BigDecimal(0.008), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/100", new BigDecimal(0.01), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/80", new BigDecimal(0.0125), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/60", new BigDecimal(0.0167), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/50", new BigDecimal(0.02), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/40", new BigDecimal(0.025), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/30", new BigDecimal(0.033), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/25", new BigDecimal(0.04), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/20", new BigDecimal(0.05), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/15", new BigDecimal(0.067), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/13", new BigDecimal(0.077), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/10", new BigDecimal(0.1), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/8", new BigDecimal(0.125), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/6", new BigDecimal(0.167), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5", new BigDecimal(0.2), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4", new BigDecimal(0.25), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/3", new BigDecimal(0.333), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2.5", new BigDecimal(0.4), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2", new BigDecimal(0.5), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1/1.6", new BigDecimal(0.625), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1.3", new BigDecimal(0.769), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1", new BigDecimal(1), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("1.3", new BigDecimal(1.6), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1.6", new BigDecimal(1.6), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("2", new BigDecimal(2), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("2.5", new BigDecimal(2.5), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("3", new BigDecimal(3), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("4", new BigDecimal(4), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("5", new BigDecimal(5), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("6", new BigDecimal(6), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("8", new BigDecimal(8), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("10", new BigDecimal(10), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("13", new BigDecimal(13), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("15", new BigDecimal(15), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("20", new BigDecimal(20), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("25", new BigDecimal(25), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("30", new BigDecimal(30), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("40", new BigDecimal(40), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("50", new BigDecimal(50), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("60", new BigDecimal(60), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("80", new BigDecimal(80), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("100", new BigDecimal(100), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("120", new BigDecimal(120), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("160", new BigDecimal(160), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("200", new BigDecimal(200), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("240", new BigDecimal(240), TYPE, Granularity.FULL));
        VALUES.add(new ExposureValue("320", new BigDecimal(320), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("400", new BigDecimal(400), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("480", new BigDecimal(480), TYPE, Granularity.FULL));
    }

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
        return VALUES;
    }

    @Override
    public Shutter displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Shutter(displacedIndex);
    }

}
