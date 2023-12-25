package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCheck("It is number", value -> (value == null) || (value instanceof Integer));
    }

    public NumberSchema required() {
        addCheck("Required check", value -> !(value == null));
        return this;
    }

    public NumberSchema positive() {
        addCheck("Positive check", value -> (value == null)
                || ((value instanceof Number && ((Integer) value) > 0)));
        return this;
    }

    public NumberSchema range(int lowBound, int topBound) {
        addCheck("Range check", value -> (value == null)
                || ((Integer) value >= lowBound) && ((Integer) value <= topBound));
        return this;
    }
}
