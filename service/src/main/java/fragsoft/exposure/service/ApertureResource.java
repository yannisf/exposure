package fragsoft.exposure.service;

import fragsoft.exposure.dto.ApertureDto;
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
    public List<ApertureDto> getApertureList() {
        log.debug("GET Request (aperture list");

        List<ApertureDto> apertures = new ArrayList<>();
        List<ExposureValue> apertureValues = ValuesStore.getApertureValues();
        for (ExposureValue ev : apertureValues) {
            apertures.add(new ApertureDto(apertureValues.indexOf(ev), ev.getLabel(), ev.getValue()));
        }

        return apertures;
    }

    @GET
    @Produces("application/json")
    @Path(value = "/{index}")
    public ApertureDto getAperture(@PathParam("index") Integer index) {
        log.debug("GET Request (aperture index [{}]", index);
        ExposureValue aperture = ValuesStore.getApertureValues().get(index);

        return new ApertureDto(index, aperture.getLabel(), aperture.getValue());
    }

}