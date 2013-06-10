package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ValueStoreTest {

    @Test
    public void testApertureValuesIncreasing() throws ExposureOutOfScaleException {
        BigDecimal previousValue = null;
        for (ExposureValue value : ValuesStore.getApertureValues()) {
            Assert.assertTrue(value.getLabel().startsWith("f/"));
            if (previousValue != null) {
                Assert.assertTrue(value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testApertureValuesFullThird() throws ExposureOutOfScaleException {
        List<ExposureValue> values = ValuesStore.getApertureValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ValuesStore.ValuesGranularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
        }
    }

    @Test
    public void testApertureValueLabel() throws ExposureOutOfScaleException {
        for (ExposureValue value : ValuesStore.getApertureValues()) {
            Assert.assertTrue(value.getLabel().startsWith("f/"));
            String pureValueFromLabel = value.getLabel().replaceAll("[^\\d.]", "");
            BigDecimal valueFromLabel = new BigDecimal(pureValueFromLabel);
            Assert.assertEquals(valueFromLabel, value.getValue());
        }
    }

    @Test
    public void testShutterValuesIncreasing() throws ExposureOutOfScaleException {
        BigDecimal previousValue = null;
        for (ExposureValue value : ValuesStore.getShutterValues()) {
            if (previousValue != null) {
                Assert.assertTrue(value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testShutterValuesFullThird() throws ExposureOutOfScaleException {
        List<ExposureValue> values = ValuesStore.getShutterValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ValuesStore.ValuesGranularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
        }
    }

    @Test
    public void testShutterValueLabel() throws ExposureOutOfScaleException {
        BigDecimal accuracy = new BigDecimal("0.00000001");
        for (ExposureValue value : ValuesStore.getShutterValues()) {
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
        BigDecimal previousValue = null;
        for (ExposureValue value : ValuesStore.getIsoValues()) {
            if (previousValue != null) {
                Assert.assertTrue("Discontinuity on ISO label " + value.getLabel(),
                        value.getValue().compareTo(previousValue) > 0);
            }
            previousValue = value.getValue();
        }
    }

    @Test
    public void testIsoValuesFullThird() throws ExposureOutOfScaleException {
        List<ExposureValue> values = ValuesStore.getIsoValues();
        for (int i = 0; i < values.size(); i += 3) {
            Assert.assertSame(values.get(i).getGranularity(), ValuesStore.ValuesGranularity.FULL);
            if (i + 1 < values.size()) {
                Assert.assertSame(values.get(i + 1).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
            if (i + 2 < values.size()) {
                Assert.assertSame(values.get(i + 2).getGranularity(), ValuesStore.ValuesGranularity.THIRD);
            }
        }
    }

    @Test
    public void testIsoValueLabel() throws ExposureOutOfScaleException {
        for (ExposureValue value : ValuesStore.getIsoValues()) {
            String pureValueFromLabel = value.getLabel();
            BigDecimal valueFromLabel = new BigDecimal(pureValueFromLabel);
            Assert.assertEquals(valueFromLabel, value.getValue());
        }
    }

}
