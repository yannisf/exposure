package fragsoft.exposure.service;

import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue;
import fragsoft.exposure.model.parameters.Shutter;
import fragsoft.exposure.model.parameters.ValuesStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/shutter")
public class ShutterResource {

    private static final Logger log = LoggerFactory.getLogger(ShutterResource.class);

    @GET
    @Produces("application/json")
    public List<ExposureValueDto> getShutterList() {
        log.debug("GET Request (shutter list)");

        List<ExposureValueDto> shutters = new ArrayList<>();
        List<ExposureValue> shutterValues = ValuesStore.getShutterValues();
        for (ExposureValue ev : shutterValues) {
            shutters.add(new ExposureValueDto(ev.getLabel(), ev.getValue()));
        }

        return shutters;
    }

    @GET
    @Produces("application/json")
    @Path(value = "/{index}")
    public ExposureValueDto getAperture(@PathParam("index") Integer index) {
        log.debug("GET Request (shutter index [{}])", index);
        ExposureValue shutter = ValuesStore.getShutterValues().get(index);

        return new ExposureValueDto(shutter.getLabel(), shutter.getValue());
    }

    @GET
    @Produces("application/json")
    @Path(value = "match/{value}")
    public ExposureValueDto getAperture(@PathParam("value") String value) throws NoMatchException {
        log.debug("GET Request (Shutter match [{}])", value);
        Shutter matchShutter = new Shutter(value);
        ExposureValue shutter = matchShutter.getValue();

        return new ExposureValueDto(shutter.getLabel(), shutter.getValue());
    }

}