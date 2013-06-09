package fragsoft.exposure.parameters;

import fragsoft.exposure.exception.ExposureOutOfScaleException;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class ValueStoreTest {

    @Test
    public void testApertureValuesIncreasing() throws ExposureOutOfScaleException {
        Aperture aperture = new Aperture(0);
        List<ExposureValue> values = aperture.getValues();
        BigDecimal previousValue = null;
        for (ExposureValue value : values) {
            Assert.assertTrue(value.getLabel().startsWith("f/"));
            if (previousValue != null) {
                Assert.assertTrue(value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testApertureValuesFullThird() throws ExposureOutOfScaleException {
        Aperture aperture = new Aperture(0);
        List<ExposureValue> values = aperture.getValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ExposureValue.Granularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ExposureValue.Granularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ExposureValue.Granularity.THIRD);
            }
        }
    }

    public void testApertureValueLabel() throws ExposureOutOfScaleException {
        Aperture aperture = new Aperture(0);
        List<ExposureValue> values = aperture.getValues();
        for (ExposureValue value : values) {
            Assert.assertTrue(value.getLabel().startsWith("f/"));
            String pureValueFromLabel = value.getLabel().replaceAll("[^\\d.]", "");
            BigDecimal valueFromLabel = new BigDecimal(pureValueFromLabel);
            Assert.assertEquals(valueFromLabel, value.getValue());
        }
    }

    @Test
    public void testShutterValuesIncreasing() throws ExposureOutOfScaleException {
        Shutter shutter = new Shutter(0);
        List<ExposureValue> values = shutter.getValues();
        BigDecimal previousValue = null;
        for (ExposureValue value : values) {
            if (previousValue != null) {
                Assert.assertTrue(value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testShutterValuesFullThird() throws ExposureOutOfScaleException {
        Shutter shutter = new Shutter(0);
        List<ExposureValue> values = shutter.getValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ExposureValue.Granularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ExposureValue.Granularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ExposureValue.Granularity.THIRD);
            }
        }
    }

//    @Test
//    public void testShutterValueLabel() throws ExposureOutOfScaleException {
//        Shutter shutter = new Shutter(0);
//        List<ExposureValue> values = shutter.getValues();
//        for (ExposureValue value : values) {
//            BigDecimal valueFromLabel = null;
//            if (value.getLabel().contains("/")) {
//                String[] strings = value.getLabel().split("/");
//                valueFromLabel = new BigDecimal(strings[0]).divide(new BigDecimal(strings[1]), 5);
//                System.out.println(valueFromLabel);
//            } else {
//                valueFromLabel = new BigDecimal(value.getLabel(), 5);
//            }
//            System.out.println(valueFromLabel.compareTo(value.getValue()));
//        }
//    }

    @Test
    public void testIsoValuesIncreasing() throws ExposureOutOfScaleException {
        Iso iso = new Iso(0);
        List<ExposureValue> values = iso.getValues();
        BigDecimal previousValue = null;
        for (ExposureValue value : values) {
            if (previousValue != null) {
                Assert.assertTrue(value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testIsoValuesFullThird() throws ExposureOutOfScaleException {
        Iso iso = new Iso(0);
        List<ExposureValue> values = iso.getValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ExposureValue.Granularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ExposureValue.Granularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ExposureValue.Granularity.THIRD);
            }
        }
    }

    public void testIsoValueLabel() throws ExposureOutOfScaleException {
        Iso iso = new Iso(0);
        List<ExposureValue> values = iso.getValues();
        for (ExposureValue value : values) {
            String pureValueFromLabel = value.getLabel().replaceAll("[^\\d.]", "");
            BigDecimal valueFromLabel = new BigDecimal(pureValueFromLabel);
            Assert.assertEquals(valueFromLabel, value.getValue());
        }
    }

}
