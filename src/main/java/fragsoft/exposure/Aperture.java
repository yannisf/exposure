package fragsoft.exposure;

import fragsoft.exposure.ExposureValue.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Aperture extends ExposureParameter {

    private static final List<ExposureValue> VALUES = new ArrayList<ExposureValue>();

    static {
        VALUES.add(new ExposureValue("f/1", new BigDecimal(1), Type.APERTURE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("f/1.1", new BigDecimal(1.1), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.3", new BigDecimal(1.3), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.4", new BigDecimal(1.4), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/1.6", new BigDecimal(1.6), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/1.8", new BigDecimal(1.8), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2", new BigDecimal(2), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/2.2", new BigDecimal(2.2), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2.5", new BigDecimal(2.5), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/2.8", new BigDecimal(2.8), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/3.2", new BigDecimal(3.2), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/3.6", new BigDecimal(3.6), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/4", new BigDecimal(4), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/4.5", new BigDecimal(4.5), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/5", new BigDecimal(5), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/5.6", new BigDecimal(5.6), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/6.3", new BigDecimal(6.3), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/7.1", new BigDecimal(7.1), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/8", new BigDecimal(8), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/9", new BigDecimal(9), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/10", new BigDecimal(10), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/11", new BigDecimal(11), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/13", new BigDecimal(13), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/14", new BigDecimal(14), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/16", new BigDecimal(16), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/18", new BigDecimal(18), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/20", new BigDecimal(20), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/22", new BigDecimal(22), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/25", new BigDecimal(25), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/29", new BigDecimal(29), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/32", new BigDecimal(32), Type.APERTURE, Granularity.FULL));
        VALUES.add(new ExposureValue("f/36", new BigDecimal(36), Type.APERTURE, Granularity.THIRD));
        VALUES.add(new ExposureValue("f/40", new BigDecimal(40), Type.APERTURE, Granularity.THIRD));
    }

    public Aperture(String label) {
        super(label);
    }

    @Override
    protected List<ExposureValue> getValues() {
        return VALUES;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ExposureParameter displaceBy(Integer displacement) {
        return new Aperture(getValues().get(getIndex() + displacement).getLabel());
    }

}
