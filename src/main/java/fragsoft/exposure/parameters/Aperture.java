package fragsoft.exposure.parameters;

import fragsoft.exposure.exception.ExposureOutOfScaleException;
import fragsoft.exposure.exception.NoMatchException;
import fragsoft.exposure.parameters.ExposureValue.Granularity;
import fragsoft.exposure.parameters.ExposureValue.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aperture extends ExposureParameter {

    public static final Type type = Type.APERTURE;

    private static final List<ExposureValue> VALUES = new ArrayList<>();

    static {
        VALUES.add(new ExposureValue("f/1", new BigDecimal("1"), type, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("f/1.1", new BigDecimal("1.1"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.3", new BigDecimal("1.3"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.4", new BigDecimal("1.4"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/1.6", new BigDecimal("1.6"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.8", new BigDecimal("1.8"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2", new BigDecimal("2"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/2.2", new BigDecimal("2.2"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2.5", new BigDecimal("2.5"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2.8", new BigDecimal("2.8"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/3.2", new BigDecimal("3.2"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/3.6", new BigDecimal("3.6"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/4", new BigDecimal("4"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/4.5", new BigDecimal("4.5"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/5", new BigDecimal("5"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/5.6", new BigDecimal("5.6"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/6.3", new BigDecimal("6.3"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/7.1", new BigDecimal("7.1"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/8", new BigDecimal("8"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/9", new BigDecimal("9"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/10", new BigDecimal("10"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/11", new BigDecimal("11"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/13", new BigDecimal("13"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/14", new BigDecimal("14"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/16", new BigDecimal("16"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/18", new BigDecimal("18"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/20", new BigDecimal("20"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/22", new BigDecimal("22"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/25", new BigDecimal("25"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/29", new BigDecimal("29"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/32", new BigDecimal("32"), type, Granularity.FULL));
        VALUES.add(new ExposureValue("f/36", new BigDecimal("36"), type, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/40", new BigDecimal("40"), type, Granularity.THIRD));
    }

    public Aperture(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Aperture(String label) throws NoMatchException {
        super(label);
    }

    @Override
    public String getSymbol() {
        return type.getSymbol();
    }

    @Override
    protected List<ExposureValue> getValues() {
        return Collections.unmodifiableList(VALUES);
    }

    @Override
    public Aperture displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Aperture(displacedIndex);
    }

}
