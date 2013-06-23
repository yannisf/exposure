package fragsoft.exposure.service;

import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.Aperture;
import fragsoft.exposure.model.parameters.ExposureValue;
import fragsoft.exposure.model.parameters.ValuesStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/aperture")
public class ApertureResource {

    private static final Logger log = LoggerFactory.getLogger(ApertureResource.class);

    @GET
    @Produces("application/json")
    public List<ExposureValueDto> getApertureList() {
        log.debug("GET Request (aperture list)");

        List<ExposureValueDto> apertures = new ArrayList<>();
        List<ExposureValue> apertureValues = ValuesStore.getApertureValues();
        for (ExposureValue ev : apertureValues) {
            apertures.add(new ExposureValueDto(ev.getLabel(), ev.getValue()));
        }

        return apertures;
    }

    @GET
    @Produces("application/json")
    @Path(value = "/{index}")
    public ExposureValueDto getAperture(@PathParam("index") Integer index) {
        log.debug("GET Request (aperture index [{}])", index);
        ExposureValue aperture = ValuesStore.getApertureValues().get(index);

        return new ExposureValueDto(aperture.getLabel(), aperture.getValue());
    }

    @GET
    @Produces("application/json")
    @Path(value = "match/{value}")
    public ExposureValueDto getAperture(@PathParam("value") String value) throws NoMatchException {
        log.debug("GET Request (Shutter match [{}])", value);
        Aperture matchAperture = new Aperture(value);
        ExposureValue aperture = matchAperture.getValue();

        return new ExposureValueDto(aperture.getLabel(), aperture.getValue());
    }

}