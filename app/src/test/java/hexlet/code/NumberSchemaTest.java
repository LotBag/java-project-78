package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private Validator v = new Validator();
    private NumberSchema schema = v.number();

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

    @Test
    public void testNumberValidator() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        assertThat(schema.positive().isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        schema.range(6, 9);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(10)).isFalse();
    }

}
