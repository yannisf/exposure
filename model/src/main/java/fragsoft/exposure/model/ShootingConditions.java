package fragsoft.exposure.model;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.Aperture;
import fragsoft.exposure.model.parameters.Iso;
import fragsoft.exposure.model.parameters.Shutter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ShootingConditions implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(ShootingConditions.class);

    public enum Priority {
        APERTURE, SHUTTER
    }

    private Iso iso;
    private Aperture aperture;
    private Shutter shutter;
    private Priority priority;

    public ShootingConditions(Integer initialIsoIndex,
                              Integer initialApertureIndex,
                              Integer initialShutterIndex) throws ExposureOutOfScaleException {
        iso = new Iso(initialIsoIndex);
        aperture = new Aperture(initialApertureIndex);
        shutter = new Shutter(initialShutterIndex);
    }

    public ShootingConditions(String initialIsoLabel,
                              String initialApertureLabel,
                              String initialShutterLabel) throws NoMatchException {
        iso = new Iso(initialIsoLabel);
        aperture = new Aperture(initialApertureLabel);
        shutter = new Shutter(initialShutterLabel);
    }

    public ShootingConditions(Iso initialIso, Aperture initialAperture, Shutter initialShutter) {
        this.iso = initialIso;
        this.aperture = initialAperture;
        this.shutter = initialShutter;
    }

    public Iso getIso() {
        return iso;
    }

    public Aperture getAperture() {
        return aperture;
    }

    public Shutter getShutter() {
        return shutter;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void updateAperture(String equivalentApertureLabel) throws NoMatchException, ExposureOutOfScaleException {
        Aperture equivalentAperture = new Aperture(equivalentApertureLabel);
        updateAperture(equivalentAperture);
    }

    public void updateAperture(Integer equivalentApertureIndex) throws ExposureOutOfScaleException {
        Aperture equivalentAperture = new Aperture(equivalentApertureIndex);
        updateAperture(equivalentAperture);
    }

    public void updateAperture(Aperture equivalentAperture) throws ExposureOutOfScaleException {
        Integer indexDifference = equivalentAperture.getIndex() - aperture.getIndex();
        aperture = equivalentAperture;
        shutter = shutter.displaceBy(indexDifference);
    }

    public void updateShutter(String equivalentShutterLabel) throws NoMatchException, ExposureOutOfScaleException {
        Shutter equivalentShutter = new Shutter(equivalentShutterLabel);
        updateShutter(equivalentShutter);
    }

    public void updateShutter(Integer equivalentShutterIndex) throws ExposureOutOfScaleException {
        Shutter equivalentShutter = new Shutter(equivalentShutterIndex);
        updateShutter(equivalentShutter);
    }

    public void updateShutter(Shutter equivalentShutter) throws ExposureOutOfScaleException {
        Integer indexDifference = equivalentShutter.getIndex() - aperture.getIndex();
        shutter = equivalentShutter;
        aperture = aperture.displaceBy(indexDifference);
    }

    public void updateIso(String equivalentIsoLabel) throws NoMatchException, ExposureOutOfScaleException {
        Iso updatedIso = new Iso(equivalentIsoLabel);
        updateIso(updatedIso);
    }

    public void updateIso(Integer equivalentIsoIndex) throws ExposureOutOfScaleException {
        Iso updatedIso = new Iso(equivalentIsoIndex);
        updateIso(updatedIso);
    }

    public void updateIso(Iso equivalentIso) throws ExposureOutOfScaleException {
        Integer indexDifference = equivalentIso.getIndex() - iso.getIndex();
        priorityControl();
        if (priority == Priority.APERTURE) {
            shutter = shutter.displaceBy(-indexDifference);
        } else if (priority == Priority.SHUTTER) {
            aperture = aperture.displaceBy(indexDifference);
        }
        iso = equivalentIso;
    }

    private void priorityControl() {
        if (priority != null) {
            LOG.debug("Priority already set to {}", priority);
        } else {
            LOG.debug("Priority not set, assuming aperture");
            priority = Priority.APERTURE;
        }
    }

    @Override
    public String toString() {
        return iso + " " + aperture + " " + shutter;
    }

}
