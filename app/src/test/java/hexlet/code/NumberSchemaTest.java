package hexlet.code;

import hexlet.code.schemas.NumberSchemas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    Validator v = new Validator();
    NumberSchemas schema = new NumberSchemas();

    @Test
    public void beforeAddCheck() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
    }

    @Test
    public void requiredTest() {
        schema.required();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void positiveTest() {
        schema.positive();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
    }

    @Test
    public void rangeTest() {
        schema.range(3, 5);

        assertTrue(schema.isValid(3));
        assertTrue(schema.isValid(4));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(6));
    }
}
