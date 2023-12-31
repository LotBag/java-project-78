package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private Validator v = new Validator();
    private StringSchema schema = v.string();

    @Test
    public void testBeforeAddCheck() {
        final int inValidObject = 5;

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(inValidObject));
    }

    @Test
    public void addRequiredTest() {
        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void addMinLengthTest() {
        schema.minLength(2);

        assertTrue(schema.isValid("OwO"));
        assertFalse(schema.isValid("T"));
    }

    @Test
    public void addContainTest() {
        schema.contains("w");

        assertTrue(schema.isValid("UwU"));
        assertFalse(schema.isValid("U_U"));
    }
}
