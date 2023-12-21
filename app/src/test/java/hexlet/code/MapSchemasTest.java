package hexlet.code;

import hexlet.code.schemas.MapSchemas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemasTest {
    private Validator v = new Validator();
    private MapSchemas schema = new MapSchemas();
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
        schema.sizeOf(1);

        assertTrue(schema.isValid(testMap));

        testMap.put("in", "correct");

        assertFalse(schema.isValid(testMap));
    }
}
