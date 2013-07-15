package fragsoft.exposure.service;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.ExposureValue;
import fragsoft.exposure.model.parameters.Iso;
import fragsoft.exposure.model.parameters.ValuesStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/iso")
public class IsoResource {

    private static final Logger log = LoggerFactory.getLogger(IsoResource.class);

    @GET
    @Produces("application/json")
    public List<ExposureValueDto> getIsoList() {
        log.debug("GET Request (ISO list)");

        List<ExposureValueDto> isos = new ArrayList<>();
        List<ExposureValue> isoValues = ValuesStore.getIsoValues();
        for (ExposureValue ev : isoValues) {
            isos.add(new ExposureValueDto(ev.getLabel(), ev.getValue(), isoValues.indexOf(ev)));
        }

        return isos;
    }

    @GET
    @Produces("application/json")
    @Path(value = "/{index}")
    public ExposureValueDto getIso(@PathParam("index") Integer index) {
        log.debug("GET Request (ISO index [{}])", index);
        ExposureValue iso = ValuesStore.getIsoValues().get(index);

        return new ExposureValueDto(iso.getLabel(), iso.getValue(), index);
    }

    @GET
    @Produces("application/json")
    @Path(value = "match/{value}")
    public ExposureValueDto getIso(@PathParam("value") String value) throws NoMatchException, ExposureOutOfScaleException {
        log.debug("GET Request (ISO match [{}])", value);
        Iso matchIso = new Iso(value);
        ExposureValue iso = matchIso.getValue();

        return new ExposureValueDto(iso.getLabel(), iso.getValue(), matchIso.getIndex());
    }

}