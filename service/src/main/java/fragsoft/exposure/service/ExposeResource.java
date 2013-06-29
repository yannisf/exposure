package fragsoft.exposure.service;

import fragsoft.exposure.model.ShootingConditions;
import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;

@Path("/expose")
public class ExposeResource {

    private static final Logger log = LoggerFactory.getLogger(ExposeResource.class);

    @GET
    @Produces("application/json")
    @Path(value = "/{isoIndex}/{apertureIndex}/{shutterIndex}")
    public Integer getEquivalentExposure(
            @PathParam("isoIndex") Integer isoIndex,
            @PathParam("apertureIndex") Integer apertureIndex,
            @PathParam("shutterIndex") Integer shutterIndex,
            @QueryParam("toIso") Integer toIsoIndex,
            @QueryParam("toAperture") Integer toApertureIndex,
            @QueryParam("toSehutter") Integer toShutterIndex) throws ExposureOutOfScaleException {
        log.debug("GET Request (Equivalent exposure for indexed [{}:{}:{}])",
                new Object[]{isoIndex, apertureIndex, shutterIndex});

        //TODO: This throws an exception that should be handled here
        ShootingConditions conditions = new ShootingConditions(isoIndex, apertureIndex, shutterIndex);

        boolean toIsoMode = toIsoIndex != null;
        boolean toApertureMode = toApertureIndex != null;
        boolean toShutterMode = toShutterIndex != null;

        Integer outcome = 0;
        if (toIsoMode) {
            conditions.updateIso(toIsoIndex);
            outcome = conditions.getAperture().getIndex();
        } else if (toApertureMode) {
            conditions.updateAperture(toApertureIndex);
            outcome = conditions.getShutter().getIndex();
        } else if (toShutterMode) {
            conditions.updateShutter(toShutterIndex);
            outcome = conditions.getAperture().getIndex();
        }

        return outcome;
    }

}