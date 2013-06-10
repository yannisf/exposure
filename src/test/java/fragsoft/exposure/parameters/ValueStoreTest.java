package fragsoft.exposure.parameters;

import fragsoft.exposure.exception.ExposureOutOfScaleException;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.math.*;
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

    @Test
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

    @Test
    public void testShutterValueLabel() throws ExposureOutOfScaleException {
        BigDecimal accuracy = new BigDecimal("0.00000001");
        Shutter shutter = new Shutter(0);
        List<ExposureValue> values = shutter.getValues();
        for (ExposureValue value : values) {
            BigDecimal valueFromLabel;
            if (value.getLabel().contains("/")) {
                String[] strings = value.getLabel().split("/");
                valueFromLabel = new BigDecimal(strings[0]).divide(new BigDecimal(strings[1]), 8, RoundingMode.HALF_DOWN);
            } else {
                valueFromLabel = new BigDecimal(value.getLabel()).setScale(8);
            }

            Assert.assertFalse("Shutter label " + value.getLabel() + " does not match",
                    valueFromLabel.subtract(value.getValue()).abs().compareTo(accuracy) > 0);
        }
    }

    @Test
    public void testIsoValuesIncreasing() throws ExposureOutOfScaleException {
        Iso iso = new Iso(0);
        List<ExposureValue> values = iso.getValues();
        BigDecimal previousValue = null;
        for (ExposureValue value : values) {
            if (previousValue != null) {
                Assert.assertTrue("Discontinuity on ISO label " + value.getLabel(),
                        value.getValue().compareTo(previousValue) > 0);
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

    @Test
    public void testIsoValueLabel() throws ExposureOutOfScaleException {
        Iso iso = new Iso(0);
        List<ExposureValue> values = iso.getValues();
        for (ExposureValue value : values) {
            String pureValueFromLabel = value.getLabel();
            BigDecimal valueFromLabel = new BigDecimal(pureValueFromLabel);
            Assert.assertEquals(valueFromLabel, value.getValue());
        }
    }

}
