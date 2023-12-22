package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private Map<String, Predicate> checks = new HashMap<>();

    protected final void addCheck(String checkName, Predicate condition) {
        checks.put(checkName, condition);
    }

    public final boolean isValid(Object value) {
        for (Map.Entry<String, Predicate> map : checks.entrySet()) {
            if (!(map.getValue().test(value))) {
                return false;
            }
        }
        return true;
    }
}

