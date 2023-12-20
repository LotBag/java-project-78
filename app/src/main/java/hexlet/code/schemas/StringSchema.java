package hexlet.code.schemas;

public class StringSchema extends BaseSchemas {
    public StringSchema() {
        addCheck("Is string check", value -> (value == null) || (value.getClass() == String.class));
    }

    public StringSchema required() {
        addCheck("Require check", value -> !((value) == null || value instanceof String && ((String) value).isEmpty()));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck("Min length check", value -> ((String) value).length() >= minLength);
        return this;
    }

    public StringSchema contains(String string) {
        addCheck("Check contains", value -> ((String) value).contains(string));
        return this;
    }
}

