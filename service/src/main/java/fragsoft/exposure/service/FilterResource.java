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

}