package fragsoft.exposure.model.parameters;

import fragsoft.exposure.model.exception.ExactMatchNotFoundException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExposureParameterTest {

    @DataProvider(name = "apertureTestSampleProvider")
    public Object[][] apertureTestSampleProvider() {
        return new Object[][] {
                {"f/3.2", 10},
                {"f/10", 20},
                {"f/22", 27},
        };
    }

    @Test(dataProvider = "apertureTestSampleProvider")
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

}
