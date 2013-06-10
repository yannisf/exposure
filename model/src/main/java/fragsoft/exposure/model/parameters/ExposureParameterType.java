package fragsoft.exposure.model.parameters;

public enum ExposureParameterType {
    ISO("ISO"),
    APERTURE("A"),
    SHUTTER("S");

    private String symbol;

    ExposureParameterType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}