package fragsoft.exposure;

import fragsoft.exposure.ExposureValue.*;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Shutter {

    public static final List<ExposureValue> VALUES = new ArrayList<ExposureValue>();

    static {

        VALUES.add(new ExposureValue("1/8000", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/6400", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5000", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4000", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/3200", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2500", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2000", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/1600", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1250", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1000", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/800", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/640", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/500", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/400", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/320", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/250", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/200", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/160", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/125", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/100", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/80", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/60", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/50", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/40", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/30", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/25", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/20", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/15", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/13", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/10", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/8", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/6", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/5", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/4", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/3", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2.5", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/2", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1/1.6", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1/1.3", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1.3", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("1.6", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));

        VALUES.add(new ExposureValue("2", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("2.5", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("3", new BigDecimal(), Type.SHUTTER, Granularity.THIRD));

        VALUES.add(new ExposureValue("4", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("5", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"5");
        VALUES.add(new ExposureValue("6", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"6");

        VALUES.add(new ExposureValue("8", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL)"8");
        VALUES.add(new ExposureValue("10", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"10");
        VALUES.add(new ExposureValue("13", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"13");

        VALUES.add(new ExposureValue("15", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL)"15");
        VALUES.add(new ExposureValue("20", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"20");
        VALUES.add(new ExposureValue("25", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"25");

        VALUES.add(new ExposureValue("30", new BigDecimal(), Type.SHUTTER, ExposureValue.Granularity.FULL)"30");
        VALUES.add(new ExposureValue("40", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"40");
        VALUES.add(new ExposureValue("50", new BigDecimal(), Type.SHUTTER, Granularity.THIRD)"50");

        VALUES.add(new ExposureValue("60", new BigDecimal(60), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("80", new BigDecimal(80), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("100", new BigDecimal(100), Type.SHUTTER, Granularity.THIRD));

        VALUES.add(new ExposureValue("120", new BigDecimal(120), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("160", new BigDecimal(160), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("200", new BigDecimal(200), Type.SHUTTER, Granularity.THIRD));

        VALUES.add(new ExposureValue("240", new BigDecimal(240), Type.SHUTTER, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("320", new BigDecimal(320), Type.SHUTTER, Granularity.THIRD));
        VALUES.add(new ExposureValue("400", new BigDecimal(400), Type.SHUTTER, Granularity.THIRD));

        VALUES.add(new ExposureValue("480", new BigDecimal(480), Type.SHUTTER, ExposureValue.Granularity.FULL));
    }

    private Integer index;
    private ExposureValue value;

    public Shutter(ExposureValue value) {
        setValue(value);
    }

    public Integer getIndex() {
        return index;
    }

    public ExposureValue getValue() {
        return value;
    }

    private void setValue(ExposureValue value) {
        for (ExposureValue shutterSpeed : VALUES) {
            if (shutterSpeed.equals(value)) {
                this.value = value;
                this.index = VALUES.indexOf(shutterSpeed);
            }
        }
    }

    public Shutter displaceBy(Integer displacement) {
        return new Shutter(VALUES.get(index + displacement));
    }

    @Override
    public String toString() {
        return "S[" + value.getLabel() + "]";
    }
}
