package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    @Test
    void testBeforeAddCheck() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }
}
