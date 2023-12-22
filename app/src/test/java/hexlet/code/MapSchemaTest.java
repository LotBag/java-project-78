package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    private Validator v = new Validator();
    private MapSchema schema = v.map();
    private Map<String, String> testMap = new HashMap<>();

    @BeforeEach
    final void beforeAll() {
        testMap.put("OwO", "UwU");
    }

    @Test
    public void beforeAddCheck() {
        assertTrue(schema.isValid(null));
    }

    @Test
    public void requiredCheckTest() {
        schema.required();

        assertTrue(schema.isValid(testMap));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void sizeOfCheckTest() {
        schema.sizeof(1);

        assertTrue(schema.isValid(testMap));

        testMap.put("in", "correct");

        assertFalse(schema.isValid(testMap));
    }

    @Test
    public void shapeCheckTest() {
        Validator validator = new Validator();
        MapSchema schema2 = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());

        schema2.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        final int incorrectAge = 100;
        human1.put("name", "Kolya");
        human1.put("age", incorrectAge);

        assertTrue(schema2.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        assertTrue(schema2.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        assertFalse(schema2.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        final int inCorrectAge = -5;
        human4.put("name", "Valya");
        human4.put("age", inCorrectAge);

        assertFalse(schema2.isValid(human4));
    }
}
