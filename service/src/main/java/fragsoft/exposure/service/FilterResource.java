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
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/filter")
public class FilterResource {

    private static final Logger log = LoggerFactory.getLogger(FilterResource.class);

    @GET
    @Produces("application/json")
    public List<ExposureValueDto> getFilterList() {
        log.debug("GET Request (filter list)");

        List<ExposureValueDto> filters = new ArrayList<>();
        List<ExposureValue> filterValues = ValuesStore.getFilterValues();
        for (ExposureValue ev : filterValues) {
            filters.add(new ExposureValueDto(ev.getLabel(), ev.getValue(), filterValues.indexOf(ev)));
        }

        return filters;
    }

    @GET
    @Produces("application/json")
    @Path(value = "/{stops}")
    public ExposureValueDto getFilter(
            @PathParam("stops")BigDecimal stops,
            @QueryParam("shutter") BigDecimal shutter) throws NoMatchException {

        log.debug("GET Request (filter [{}])", stops);
        double multiplier = Math.pow(2, stops.doubleValue());
        double adjusted = multiplier * shutter.doubleValue();

        Shutter adjustedShutterEv = new Shutter(String.valueOf(adjusted));
        return new ExposureValueDto(
                adjustedShutterEv.getValue().getLabel(),
                adjustedShutterEv.getValue().getValue(),
                adjustedShutterEv.getIndex());
    }

}