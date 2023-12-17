package hexlet.code;

import hexlet.code.schemas.BaseSchemas;
import hexlet.code.schemas.StringSchema;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }
}
