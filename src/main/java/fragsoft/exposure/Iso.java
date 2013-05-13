package fragsoft.exposure;

import java.util.ArrayList;
import java.util.List;

public class Iso {

    public static final List<Integer> VALUES = new ArrayList<Integer>();

    static {
        VALUES.add(25); VALUES.add(32); VALUES.add(40);
        VALUES.add(50); VALUES.add(64); VALUES.add(80);
        VALUES.add(100); VALUES.add(125); VALUES.add(160);
        VALUES.add(200); VALUES.add(250); VALUES.add(320);
        VALUES.add(400); VALUES.add(500); VALUES.add(640);
        VALUES.add(800); VALUES.add(1000); VALUES.add(1250);
        VALUES.add(1600); VALUES.add(2000); VALUES.add(2500);
        VALUES.add(3200); VALUES.add(4000); VALUES.add(5000);
        VALUES.add(6400); VALUES.add(8000); VALUES.add(10000);
        VALUES.add(12800); VALUES.add(16000); VALUES.add(20000);
        VALUES.add(25600);
    }

    private Integer index;
    private Integer value;

    public Iso(Integer value) {
        setValue(value);
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getValue() {
        return value;
    }

    private void setValue(Integer value) {
        for (Integer iso : VALUES) {
            if (value.equals(iso)) {
                this.value = value;
                this.index = VALUES.indexOf(iso);
            }
        }
    }

    @Override
    public String toString() {
        return "ISO[" + value + "]";
    }

}
