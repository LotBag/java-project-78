package hexlet.code;

import hexlet.code.schemas.NumberSchemas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private Validator v = new Validator();
    private NumberSchemas schema = v.number();

    @Test
    public void beforeAddCheck() {
        final int validNum = 5;

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(validNum));
    }

    @Test
    public void requiredTest() {
        schema.required();

        assertFalse(schema.isValid(null));
    }

    @Test
    public void positiveTest() {
        final int validNum = 5;
        final int inValidNum = -5;

        schema.positive();

        assertTrue(schema.isValid(validNum));
        assertFalse(schema.isValid(inValidNum));
    }

    @Test
    public void rangeTest() {
        final int lowBound = 3;
        final int topBound = 5;
        final int outOfBound = 6;

        schema.range(lowBound, topBound);

        assertTrue(schema.isValid(lowBound));
        assertTrue(schema.isValid(topBound));
        assertFalse(schema.isValid(outOfBound));
    }
}
