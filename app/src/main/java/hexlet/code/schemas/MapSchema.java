package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        addCheck("It is Map?", value -> (value == null) || (value instanceof Map<?, ?>));
    }

    public MapSchema required() {
        addCheck("Required check", value -> !(value == null));
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("Size of check", value -> ((HashMap<?, ?>) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        addCheck("Shape", value -> {
            for (Map.Entry<String, Object> entry : ((HashMap<String, Object>) value).entrySet()) {
                if (!map.get(entry.getKey()).isValid(entry.getValue())) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
