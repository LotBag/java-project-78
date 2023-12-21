package hexlet.code.schemas;

public final class NumberSchemas extends BaseSchemas {

    public NumberSchemas() {
        addCheck("It is number", value -> (value == null) || (value.getClass() == Integer.class));
    }

    public NumberSchemas required() {
        addCheck("Required check", value -> !(value == null));
        return this;
    }

    public NumberSchemas positive() {
        addCheck("Positive check", value -> ((Integer) value) > 0);
        return this;
    }

    public NumberSchemas range(int lowBound, int topBound) {
        addCheck("Range check", value -> ((Integer) value >= lowBound) && ((Integer) value <= topBound));
        return this;
    }
}
