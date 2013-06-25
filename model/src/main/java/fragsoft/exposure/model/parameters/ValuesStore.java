package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.parameters.ExposureValue.ExposureParameterType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValuesStore {

    public enum ValuesGranularity {
        FULL,
        THIRD
    }

    private static final Map<ExposureParameterType, List<ExposureValue>> VALUES = new HashMap<>();

    static {
        List<ExposureValue> apertureValues = new ArrayList<>();
        apertureValues.add(new ExposureValue("f/1", new BigDecimal("1"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/1.1", new BigDecimal("1.1"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/1.3", new BigDecimal("1.3"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/1.4", new BigDecimal("1.4"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/1.6", new BigDecimal("1.6"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/1.8", new BigDecimal("1.8"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/2", new BigDecimal("2"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/2.2", new BigDecimal("2.2"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/2.5", new BigDecimal("2.5"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/2.8", new BigDecimal("2.8"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/3.2", new BigDecimal("3.2"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/3.6", new BigDecimal("3.6"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/4", new BigDecimal("4"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/4.5", new BigDecimal("4.5"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/5", new BigDecimal("5"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/5.6", new BigDecimal("5.6"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/6.3", new BigDecimal("6.3"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/7.1", new BigDecimal("7.1"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/8", new BigDecimal("8"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/9", new BigDecimal("9"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/10", new BigDecimal("10"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/11", new BigDecimal("11"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/13", new BigDecimal("13"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/14", new BigDecimal("14"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/16", new BigDecimal("16"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/18", new BigDecimal("18"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/20", new BigDecimal("20"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/22", new BigDecimal("22"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/25", new BigDecimal("25"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/29", new BigDecimal("29"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/32", new BigDecimal("32"), ExposureParameterType.APERTURE, ValuesGranularity.FULL));
        apertureValues.add(new ExposureValue("f/36", new BigDecimal("36"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));
        apertureValues.add(new ExposureValue("f/40", new BigDecimal("40"), ExposureParameterType.APERTURE, ValuesGranularity.THIRD));

        List<ExposureValue> shutterValues = new ArrayList<>();
        shutterValues.add(new ExposureValue("1/8000", new BigDecimal("0.000125"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/6400", new BigDecimal("0.00015625"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/5000", new BigDecimal("0.0002"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/4000", new BigDecimal("0.00025"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/3200", new BigDecimal("0.0003125"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/2500", new BigDecimal("0.0004"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/2000", new BigDecimal("0.0005"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/1600", new BigDecimal("0.000625"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/1250", new BigDecimal("0.0008"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/1000", new BigDecimal("0.001"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/800", new BigDecimal("0.00125"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/640", new BigDecimal("0.0015625"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/500", new BigDecimal("0.002"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/400", new BigDecimal("0.0025"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/320", new BigDecimal("0.003125"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/250", new BigDecimal("0.004"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/200", new BigDecimal("0.005"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/160", new BigDecimal("0.00625"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/125", new BigDecimal("0.008"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/100", new BigDecimal("0.01"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/80", new BigDecimal("0.0125"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/60", new BigDecimal("0.01666667"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/50", new BigDecimal("0.02"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/40", new BigDecimal("0.025"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/30", new BigDecimal("0.03333333"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/25", new BigDecimal("0.04"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/20", new BigDecimal("0.05"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/15", new BigDecimal("0.06666667"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/13", new BigDecimal("0.07692308"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/10", new BigDecimal("0.1"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/8", new BigDecimal("0.125"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/6", new BigDecimal("0.16666667"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/5", new BigDecimal("0.2"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/4", new BigDecimal("0.25"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/3", new BigDecimal("0.33333333"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/2.5", new BigDecimal("0.4"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/2", new BigDecimal("0.5"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1/1.6", new BigDecimal("0.625"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1/1.3", new BigDecimal("0.76923077"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1", new BigDecimal("1"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("1.3", new BigDecimal("1.3"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("1.6", new BigDecimal("1.6"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("2", new BigDecimal("2"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("2.5", new BigDecimal("2.5"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("3", new BigDecimal("3"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("4", new BigDecimal("4"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("5", new BigDecimal("5"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("6", new BigDecimal("6"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("8", new BigDecimal("8"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("10", new BigDecimal("10"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("13", new BigDecimal("13"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("15", new BigDecimal("15"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("20", new BigDecimal("20"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("25", new BigDecimal("25"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("30", new BigDecimal("30"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("40", new BigDecimal("40"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("50", new BigDecimal("50"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("60", new BigDecimal("60"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("80", new BigDecimal("80"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("100", new BigDecimal("100"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("120", new BigDecimal("120"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("160", new BigDecimal("160"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("200", new BigDecimal("200"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("240", new BigDecimal("240"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));
        shutterValues.add(new ExposureValue("320", new BigDecimal("320"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("400", new BigDecimal("400"), ExposureParameterType.SHUTTER, ValuesGranularity.THIRD));
        shutterValues.add(new ExposureValue("480", new BigDecimal("480"), ExposureParameterType.SHUTTER, ValuesGranularity.FULL));

        List<ExposureValue> isoValues = new ArrayList<>();
        isoValues.add(new ExposureValue("25", new BigDecimal("25"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("32", new BigDecimal("32"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("40", new BigDecimal("40"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("50", new BigDecimal("50"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("64", new BigDecimal("64"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("80", new BigDecimal("80"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("100", new BigDecimal("100"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("125", new BigDecimal("125"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("160", new BigDecimal("160"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("200", new BigDecimal("200"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("250", new BigDecimal("250"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("320", new BigDecimal("320"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("400", new BigDecimal("400"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("500", new BigDecimal("500"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("640", new BigDecimal("640"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("800", new BigDecimal("800"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("1000", new BigDecimal("1000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("1250", new BigDecimal("1250"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("1600", new BigDecimal("1600"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("2000", new BigDecimal("2000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("2500", new BigDecimal("2500"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("3200", new BigDecimal("3200"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("4000", new BigDecimal("4000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("5000", new BigDecimal("5000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("6400", new BigDecimal("6400"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("8000", new BigDecimal("8000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("10000", new BigDecimal("10000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("12800", new BigDecimal("12800"), ExposureParameterType.ISO, ValuesGranularity.FULL));
        isoValues.add(new ExposureValue("16000", new BigDecimal("16000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("20000", new BigDecimal("20000"), ExposureParameterType.ISO, ValuesGranularity.THIRD));
        isoValues.add(new ExposureValue("25600", new BigDecimal("25600"), ExposureParameterType.ISO, ValuesGranularity.FULL));

        VALUES.put(ExposureParameterType.APERTURE, Collections.unmodifiableList(apertureValues));
        VALUES.put(ExposureParameterType.SHUTTER, Collections.unmodifiableList(shutterValues));
        VALUES.put(ExposureParameterType.ISO, Collections.unmodifiableList(isoValues));
    }

    public static List<ExposureValue> getApertureValues() {
        return VALUES.get(ExposureParameterType.APERTURE);
    }

    public static List<ExposureValue> getShutterValues() {
        return VALUES.get(ExposureParameterType.SHUTTER);
    }

    public static List<ExposureValue> getIsoValues() {
        return VALUES.get(ExposureParameterType.ISO);
    }

}
