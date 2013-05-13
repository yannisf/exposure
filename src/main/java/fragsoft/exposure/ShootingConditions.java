package fragsoft.exposure;

public class ShootingConditions {

    private Iso isoSensitivity;
    private Aperture aperture;
    private Shutter shutterSpeed;
    private Priority priority;

    public ShootingConditions(Integer setIso, String setAperture, String setShutterSpeed) {
        isoSensitivity = new Iso(setIso);
        aperture = new Aperture(setAperture);
        shutterSpeed = new Shutter(setShutterSpeed);
    }

    public ShootingConditions(Integer setIso, String setAperture, String setShutterSpeed, Priority priority) {
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

    public void updateAperture(String setUpdatedAperture) {
        System.out.println("BEFORE: " + this);
        Aperture updatedAperture = new Aperture(setUpdatedAperture);
        Integer indexDifference = updatedAperture.getIndex() - aperture.getIndex();
        aperture = updatedAperture;
        shutterSpeed = shutterSpeed.displaceBy(indexDifference);
        System.out.println("AFTER: " + this);
    }

    public void updateShutterSpeed(String setUpdatedShutterSpeed) {
        System.out.println("BEFORE: " + this);
        Shutter updatedShutterSpeed = new Shutter(setUpdatedShutterSpeed);
        Integer indexDifference = updatedShutterSpeed.getIndex() - aperture.getIndex();
        shutterSpeed = updatedShutterSpeed;
        aperture = aperture.displaceBy(indexDifference);
        System.out.println("AFTER: " + this);
    }

    @Override
    public String toString() {
        return isoSensitivity+ " " + aperture + " " + shutterSpeed;
    }

    public static final void main(String[] args) {
        ShootingConditions conditions = new ShootingConditions(200, "f/2.8", "1");
        conditions.updateAperture("f/5.6");
    }

}
