package dis.ulpgc.kata2;

public class HistogramElement {
    private final int field;
    private final int value;

    public HistogramElement(int field, int value) {
        this.field = field;
        this.value = value;
    }

    public int getField() {
        return field;
    }

    public int getValue() {
        return value;
    }
}
