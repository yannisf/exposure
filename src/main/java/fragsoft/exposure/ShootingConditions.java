package fragsoft.exposure;

import fragsoft.exposure.exception.*;
import fragsoft.exposure.parameters.*;

public class ShootingConditions {

    public enum Priority {
        APERTURE, SHUTTER
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
        System.out.println("BEFORE: " + this);
        Aperture updatedAperture = new Aperture(setUpdatedAperture);
        Integer indexDifference = updatedAperture.getIndex() - aperture.getIndex();
        aperture = updatedAperture;
        shutterSpeed = shutterSpeed.displaceBy(indexDifference);
        System.out.println("AFTER: " + this);
    }

    public void updateShutterSpeed(String setUpdatedShutterSpeed) throws NoMatchException, ExposureOutOfScaleException {
        System.out.println("BEFORE: " + this);
        Shutter updatedShutterSpeed = new Shutter(setUpdatedShutterSpeed);
        Integer indexDifference = updatedShutterSpeed.getIndex() - aperture.getIndex();
        shutterSpeed = updatedShutterSpeed;
        aperture = aperture.displaceBy(indexDifference);
        System.out.println("AFTER: " + this);
    }

    public void updateIso(String setIso) throws NoMatchException, ExposureOutOfScaleException {
        System.out.println("BEFORE: " + this);
        Iso updatedIso = new Iso(setIso);
        Integer indexDifference = updatedIso.getIndex() - isoSensitivity.getIndex();
        priorityControl();
        if (priority == Priority.APERTURE) {
            shutterSpeed = shutterSpeed.displaceBy(-indexDifference);
        } else if (priority == Priority.SHUTTER) {
            aperture = aperture.displaceBy(indexDifference);
        }
        isoSensitivity = updatedIso;
        System.out.println("AFTER: " + this);
    }

    private void priorityControl() {
        if (priority == null) {
            System.out.println("Priority not set, assuming aperture. ");
            priority = Priority.APERTURE;
        }
    }


    @Override
    public String toString() {
        return isoSensitivity+ " " + aperture + " " + shutterSpeed;
    }

    public static final void main(String[] args) throws NoMatchException, ExposureOutOfScaleException {
        ShootingConditions conditions = new ShootingConditions("200", "f/2.8", "1");
        conditions.setPriority(Priority.SHUTTER);
        conditions.updateIso("320");
    }

}
