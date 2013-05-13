package fragsoft.exposure;

import java.util.ArrayList;
import java.util.List;

public class Shutter {

    public static final List<String> VALUES = new ArrayList<String>();

    static {
        VALUES.add("1/8000"); VALUES.add("1/6400"); VALUES.add("1/5000");
        VALUES.add("1/4000"); VALUES.add("1/3200"); VALUES.add("1/2500");
        VALUES.add("1/2000"); VALUES.add("1/1600"); VALUES.add("1/1250");
        VALUES.add("1/1000"); VALUES.add("1/800"); VALUES.add("1/640");
        VALUES.add("1/500"); VALUES.add("1/400"); VALUES.add("1/320");
        VALUES.add("1/250"); VALUES.add("1/200"); VALUES.add("1/160");
        VALUES.add("1/125"); VALUES.add("1/100"); VALUES.add("1/80");
        VALUES.add("1/60"); VALUES.add("1/50"); VALUES.add("1/40");
        VALUES.add("1/30"); VALUES.add("1/25"); VALUES.add("1/20");
        VALUES.add("1/15"); VALUES.add("1/13"); VALUES.add("1/10");
        VALUES.add("1/8"); VALUES.add("1/6"); VALUES.add("1/5");
        VALUES.add("1/4"); VALUES.add("1/3"); VALUES.add("1/2.5");
        VALUES.add("1/2"); VALUES.add("1/1.6"); VALUES.add("1/1.3");
        VALUES.add("1"); VALUES.add("1.3"); VALUES.add("1.6");
        VALUES.add("2"); VALUES.add("2.5"); VALUES.add("3");
        VALUES.add("4"); VALUES.add("5"); VALUES.add("6");
        VALUES.add("8"); VALUES.add("10"); VALUES.add("13");
        VALUES.add("15"); VALUES.add("20"); VALUES.add("25");
        VALUES.add("30"); VALUES.add("40"); VALUES.add("50");
        VALUES.add("60"); VALUES.add("80"); VALUES.add("100");
        VALUES.add("120"); VALUES.add("160"); VALUES.add("200");
        VALUES.add("240"); VALUES.add("320"); VALUES.add("400");
        VALUES.add("480");
    }

    private Integer index;
    private String value;

    public Shutter(String value) {
        setValue(value);
    }

    public Integer getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        for (String shutterSpeed : VALUES) {
            if (shutterSpeed.equals(value)) {
                this.value = value;
                this.index = VALUES.indexOf(shutterSpeed);
            }
        }
    }

    public Shutter displaceBy(Integer displacement) {
        return new Shutter(VALUES.get(index + displacement));
    }

    @Override
    public String toString() {
        return "S[" + value + "]";
    }
}
