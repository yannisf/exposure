package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExactMatchNotFoundException;
import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ExposureParameterTest {

    @DataProvider(name = "apertureLabelTestSampleProvider")
    public Object[][] apertureLabelTestSampleProvider() {
        return new Object[][] {
                {"f/3.2", 10},
                {"f/10", 20},
                {"f/22", 27}
        };
    }

    @DataProvider(name = "dropNonNumericPartsProvider")
    public Object[][] dropNonNumericPartsProvider() {
        return new Object[][] {
                {"f/3.2", "3.2"},
                {"f:10", "10"},
                {"f22", "22"},
                {"22", "22"},
                {"f32as", "32"}
        };
    }

    @DataProvider(name = "shutterValueProvider")
    public Object[][] shutterValueProvider() {
        return new Object[][] {
                {new BigDecimal("0.00041"), new BigDecimal("0.0004")},
                {new BigDecimal("0.0102"), new BigDecimal("0.01")},
                {new BigDecimal("1.4"), new BigDecimal("1.3")},
                {new BigDecimal("42"), new BigDecimal("40")},
        };
    }

    @Test(dataProvider = "apertureLabelTestSampleProvider")
    public void apertureValueFromLabelSuccessTest(String label, int index) throws ExactMatchNotFoundException {
        Aperture aperture = new Aperture();
        aperture.findExposureValueFromLabel(label);
        Assert.assertSame(aperture.getIndex(), index);
    }

    @Test()
    public void apertureValueFromLabelFailTest() throws ExactMatchNotFoundException {
        String label = "f/3.2";
        int index = 0;
        Aperture aperture = new Aperture();
        aperture.findExposureValueFromLabel(label);
        Assert.assertNotSame(aperture.getIndex(), index);
    }

    @Test(expectedExceptions = {ExactMatchNotFoundException.class})
    public void apertureValueFromLabelExceptionTest() throws ExactMatchNotFoundException {
        Aperture aperture = new Aperture();
        aperture.findExposureValueFromLabel("N/A");
    }

    @Test(dataProvider = "dropNonNumericPartsProvider")
    public void dropNonNumericCharsTest(String raw, String sanitized) {
        Assert.assertEquals(ExposureParameter.dropNonNumericChars(raw), sanitized);
    }

    @Test
    public void isoDisplacementTest() throws ExposureOutOfScaleException {
        Iso iso = new Iso(3);
        Iso displacedRightIso = iso.displaceBy(2);
        Assert.assertSame(displacedRightIso.getIndex(), 5);

        Iso displacedLeftIso = iso.displaceBy(-2);
        Assert.assertSame(displacedLeftIso.getIndex(), 1);
    }

    @Test(expectedExceptions = {ExposureOutOfScaleException.class})
    public void isoDisplacementExceptionTest() throws ExposureOutOfScaleException {
        Iso iso = new Iso(3);
        iso.displaceBy(100);
    }

    @Test
    public void apertureDisplacementTest() throws ExposureOutOfScaleException {
        Aperture aperture = new Aperture(3);
        Aperture displacedRightAperture = aperture.displaceBy(2);
        Assert.assertSame(displacedRightAperture.getIndex(), 5);

        Aperture displacedLeftAperture = aperture.displaceBy(-2);
        Assert.assertSame(displacedLeftAperture.getIndex(), 1);
    }

    @Test(expectedExceptions = {ExposureOutOfScaleException.class})
    public void apertureDisplacementExceptionTest() throws ExposureOutOfScaleException {
        Aperture aperture = new Aperture(3);
        aperture.displaceBy(100);
    }

    @Test
    public void shutterDisplacementTest() throws ExposureOutOfScaleException {
        Shutter shutter = new Shutter(3);
        Shutter displacedRightShutter = shutter.displaceBy(2);
        Assert.assertSame(displacedRightShutter.getIndex(), 5);

        Shutter displacedLeftShutter = shutter.displaceBy(-2);
        Assert.assertSame(displacedLeftShutter.getIndex(), 1);
    }

    @Test(expectedExceptions = {ExposureOutOfScaleException.class})
    public void shutterDisplacementRightExceptionTest() throws ExposureOutOfScaleException {
        Shutter shutter = new Shutter(3);
        shutter.displaceBy(100);
    }

    @Test(expectedExceptions = {ExposureOutOfScaleException.class})
    public void shutterDisplacementLeftExceptionTest() throws ExposureOutOfScaleException {
        Shutter shutter = new Shutter(3);
        shutter.displaceBy(-5);
    }

    @Test(dataProvider = "shutterValueProvider")
    public void findOptimalMatchTest(BigDecimal inputValue, BigDecimal optimalValue) {
        Shutter shutter = new Shutter();
        ExposureValue exposureValue = shutter.findOptimalMatch(inputValue);
        Assert.assertEquals(exposureValue.getValue(), optimalValue);
    }

}
