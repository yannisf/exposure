package fragsoft.exposure;

import fragsoft.exposure.ExposureValue.*;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Iso {

    public static final List<ExposureValue> VALUES = new ArrayList<ExposureValue>();

    static {
        VALUES.add(new ExposureValue("25", new BigDecimal(25), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("32", new BigDecimal(32), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("40", new BigDecimal(40), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("50", new BigDecimal(50), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("64", new BigDecimal(64), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("80", new BigDecimal(80), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("100", new BigDecimal(100), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("125", new BigDecimal(125), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("160", new BigDecimal(160), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("200", new BigDecimal(200), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("250", new BigDecimal(250), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("320", new BigDecimal(320), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("400", new BigDecimal(400), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("500", new BigDecimal(500), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("640", new BigDecimal(640), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("800", new BigDecimal(800), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1000", new BigDecimal(1000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("1250", new BigDecimal(1250), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("1600", new BigDecimal(1600), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("2000", new BigDecimal(2000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("2500", new BigDecimal(2500), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("3200", new BigDecimal(3200), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("4000", new BigDecimal(4000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("5000", new BigDecimal(5000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("6400", new BigDecimal(6400), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("8000", new BigDecimal(8000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("10000", new BigDecimal(10000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("12800", new BigDecimal(12800), Type.ISO, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("16000", new BigDecimal(16000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("20000", new BigDecimal(20000), Type.ISO, Granularity.THIRD));
        VALUES.add(new ExposureValue("25600", new BigDecimal(25600), Type.ISO, ExposureValue.Granularity.FULL));
    }

    private Integer index;
    private ExposureValue value;

    public Iso(ExposureValue value) {
        setValue(value);
    }

    public Integer getIndex() {
        return index;
    }

    public ExposureValue getValue() {
        return value;
    }

    private void setValue(ExposureValue value) {
        for (ExposureValue iso : VALUES) {
            if (value.equals(iso)) {
                this.value = value;
                this.index = VALUES.indexOf(iso);
            }
        }
    }

    @Override
    public String toString() {
        return "ISO[" + value.getLabel() + "]";
    }

}
