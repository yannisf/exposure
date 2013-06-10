package fragsoft.exposure.model;

import fragsoft.exposure.model.exception.ExposureOutOfScaleException;
import fragsoft.exposure.model.exception.NoMatchException;
import fragsoft.exposure.model.parameters.Aperture;
import fragsoft.exposure.model.parameters.Iso;
import fragsoft.exposure.model.parameters.Shutter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShootingConditions {

    private static final Logger LOG = LoggerFactory.getLogger(ShootingConditions.class);

    public enum Priority {
        APERTURE, SHUTTER, MANUAL
    }

    private Iso isoSensitivity;
    private Aperture aperture;
    private Shutter shutterSpeed;
    private Priority priority;

    public ShootingConditions(String setIso, String setAperture, String setShutterSpeed) throws NoMatchException {
        isoSensitivity = new Iso(setIso);
        aperture = new Aperture(setAperture);
        shutterSpeed = new Shutter(setShutterSpeed);
    }

    public ShootingConditions(String setIso, String setAperture, String setShutterSpeed, Priority priority) throws NoMatchException {
        this(setIso, setAperture, setShutterSpeed);
        this.priority = priority;
    }

    public Iso getIsoSensitivity() {
        return isoSensitivity;
    }

    public Aperture getAperture() {
        return aperture;
    }

    public Shutter getShutterSpeed() {
        return shutterSpeed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void updateAperture(String setUpdatedAperture) throws NoMatchException, ExposureOutOfScaleException {
        LOG.info("BEFORE {}", this);
        Aperture updatedAperture = new Aperture(setUpdatedAperture);
        Integer indexDifference = updatedAperture.getIndex() - aperture.getIndex();
        aperture = updatedAperture;
        shutterSpeed = shutterSpeed.displaceBy(indexDifference);
        LOG.info("AFTER {}", this);
    }

    public void updateShutterSpeed(String setUpdatedShutterSpeed) throws NoMatchException, ExposureOutOfScaleException {
        LOG.info("BEFORE {}", this);
        Shutter updatedShutterSpeed = new Shutter(setUpdatedShutterSpeed);
        Integer indexDifference = updatedShutterSpeed.getIndex() - aperture.getIndex();
        shutterSpeed = updatedShutterSpeed;
        aperture = aperture.displaceBy(indexDifference);
        LOG.info("AFTER {}", this);
    }

    public void updateIso(String setIso) throws NoMatchException, ExposureOutOfScaleException {
        LOG.info("BEFORE {}", this);
        Iso updatedIso = new Iso(setIso);
        Integer indexDifference = updatedIso.getIndex() - isoSensitivity.getIndex();
        priorityControl();
        if (priority == Priority.APERTURE) {
            shutterSpeed = shutterSpeed.displaceBy(-indexDifference);
        } else if (priority == Priority.SHUTTER) {
            aperture = aperture.displaceBy(indexDifference);
        }
        isoSensitivity = updatedIso;
        LOG.info("AFTER {}", this);
    }

    private void priorityControl() {
        if (priority != null) {
            LOG.debug("Priority already set to {}", priority);
        } else {
            LOG.info("Priority not set, assuming aperture");
            priority = Priority.APERTURE;
        }
    }


    @Override
    public String toString() {
        return isoSensitivity + " " + aperture + " " + shutterSpeed;
    }

    public static final void main(String[] args) throws NoMatchException, ExposureOutOfScaleException {
        ShootingConditions conditions = new ShootingConditions("200", "f/2.8", "1");
        conditions.setPriority(Priority.SHUTTER);
        try {
            conditions.updateAperture("f5.6.36");
        } catch (NoMatchException nme) {
            LOG.warn("Could not evaluate value");
        }
    }

}
