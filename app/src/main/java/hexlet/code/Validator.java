package hexlet.code;

import hexlet.code.schemas.MapSchemas;
import hexlet.code.schemas.NumberSchemas;
import hexlet.code.schemas.StringSchema;

public final class Validator {
    public StringSchema string() {
        return new StringSchema();
    }
    public NumberSchemas number() {
        return new NumberSchemas();
    }
    public MapSchemas map() {
        return new MapSchemas();
    }
}
