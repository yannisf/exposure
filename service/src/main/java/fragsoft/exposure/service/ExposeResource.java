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
            @QueryParam("toShutter") Integer toShutterIndex) {
        log.debug("GET Request (Equivalent exposure for indexed [{}:{}:{}])",
                isoIndex, apertureIndex, shutterIndex);

        Integer outcome = -1;
        ShootingConditions conditions;
        try {
            conditions = new ShootingConditions(isoIndex, apertureIndex, shutterIndex);
        } catch (ExposureOutOfScaleException exception) {
            log.warn("Initial shooting conditions out of scale ", exception);
            return -2;
        }

        boolean toIsoMode = toIsoIndex != null;
        boolean toApertureMode = toApertureIndex != null;
        boolean toShutterMode = toShutterIndex != null;

        try {
            if (toIsoMode) {
                conditions.updateIso(toIsoIndex);
                outcome = conditions.getShutter().getIndex();
            } else if (toApertureMode) {
                conditions.updateAperture(toApertureIndex);
                outcome = conditions.getShutter().getIndex();
            } else if (toShutterMode) {
                conditions.updateShutter(toShutterIndex);
                outcome = conditions.getAperture().getIndex();
            }
        } catch (ExposureOutOfScaleException exception) {
            log.debug("The requested equivalent is out of scale");
        }

        return outcome;
    }

}