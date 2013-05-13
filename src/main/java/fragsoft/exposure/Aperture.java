package fragsoft.exposure;

import java.util.ArrayList;
import java.util.List;

public class Aperture {

    public static final List<String> VALUES = new ArrayList<String>();

    static {
        VALUES.add("f/1"); VALUES.add("f/1.1"); VALUES.add("f/1.3");
        VALUES.add("f/1.4"); VALUES.add("f/1.6"); VALUES.add("f/1.8");
        VALUES.add("f/2"); VALUES.add("f/2.2"); VALUES.add("f/2.5");
        VALUES.add("f/2.8"); VALUES.add("f/3.2"); VALUES.add("f/3.6");
        VALUES.add("f/4"); VALUES.add("f/4.5"); VALUES.add("f/5");
        VALUES.add("f/5.6"); VALUES.add("f/6.3"); VALUES.add("f/7.1");
        VALUES.add("f/8"); VALUES.add("f/9"); VALUES.add("f/10");
        VALUES.add("f/11"); VALUES.add("f/13"); VALUES.add("f/14");
        VALUES.add("f/16"); VALUES.add("f/18"); VALUES.add("f/20");
        VALUES.add("f/22"); VALUES.add("f/25"); VALUES.add("f/29");
        VALUES.add("f/32"); VALUES.add("f/36"); VALUES.add("f/40");
    }

    private Integer index;
    private String value;

    public Aperture(String value) {
        setValue(value);
    }

    public Integer getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        for (String aperture : VALUES) {
            if (aperture.equals(value)) {
                this.value = value;
                this.index = VALUES.indexOf(aperture);
            }
        }
    }

    public Aperture displaceBy(Integer displacement) {
        return new Aperture(VALUES.get(index + displacement));
    }

    @Override
    public String toString() {
        return "A[" + value + "]";
    }

}
