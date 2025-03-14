package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T>  {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public boolean isValid(T data) {
        for (Predicate<T> fn : checks.values()) {
            if (!fn.test(data)) {
                return false;
            }
        }
        return true;
    }
}
