package hexlet.code.schemas;

import java.util.HashMap;

public final class MapSchemas extends BaseSchemas {
    public MapSchemas() {
        addCheck("It is Map?", value -> (value == null) || (value.getClass() == HashMap.class));
    }

    public MapSchemas required() {
        addCheck("Required check", value -> !(value == null));
        return this;
    }

    public MapSchemas sizeOf(int size) {
        addCheck("Size of check", value -> ((HashMap<?, ?>) value).size() == size);
        return this;
    }
}
