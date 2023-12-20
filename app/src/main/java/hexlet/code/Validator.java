package hexlet.code;

import hexlet.code.schemas.NumberSchemas;
import hexlet.code.schemas.StringSchema;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }
    public NumberSchemas number() {
        return new NumberSchemas();
    }
}
