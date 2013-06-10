package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue.Granularity;
import fragsoft.exposure.model.parameters.ExposureValue.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Iso extends ExposureParameter {

    public static final Type TYPE = Type.ISO;

    private static final List<ExposureValue> VALUES = new ArrayList<>();

    static {
        VALUES.add(new ExposureValue("25", new BigDecimal("25"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("32", new BigDecimal("32"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("40", new BigDecimal("40"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("50", new BigDecimal("50"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("64", new BigDecimal("64"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("80", new BigDecimal("80"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("100", new BigDecimal("100"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("125", new BigDecimal("125"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("160", new BigDecimal("160"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("200", new BigDecimal("200"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("250", new BigDecimal("250"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("320", new BigDecimal("320"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("400", new BigDecimal("400"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("500", new BigDecimal("500"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("640", new BigDecimal("640"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("800", new BigDecimal("800"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("1000", new BigDecimal("1000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1250", new BigDecimal("1250"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("1600", new BigDecimal("1600"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("2000", new BigDecimal("2000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("2500", new BigDecimal("2500"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("3200", new BigDecimal("3200"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("4000", new BigDecimal("4000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("5000", new BigDecimal("5000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("6400", new BigDecimal("6400"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("8000", new BigDecimal("8000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("10000", new BigDecimal("10000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("12800", new BigDecimal("12800"), TYPE, ExposureValue.Granularity.FULL));
        VALUES.add(new ExposureValue("16000", new BigDecimal("16000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("20000", new BigDecimal("20000"), TYPE, Granularity.THIRD));
        VALUES.add(new ExposureValue("25600", new BigDecimal("25600"), TYPE, ExposureValue.Granularity.FULL));
    }

    public Iso(int index) throws ExposureOutOfScaleException {
        super(index);
    }

    public Iso(String label) throws NoMatchException {
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
    public Iso displaceBy(Integer displacement) throws ExposureOutOfScaleException {
        int displacedIndex = getIndex() + displacement;
        return new Iso(displacedIndex);
    }

}
