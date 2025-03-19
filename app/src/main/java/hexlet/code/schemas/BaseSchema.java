package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T>  {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    private boolean isRequired = false;

    public BaseSchema<T> required() {
        isRequired = true;
        return this;
    }

    public final boolean isValid(T data) {
        if (Objects.isNull(data)) {
            return !isRequired;
        }
        for (Predicate<T> fn : checks.values()) {
            if (!fn.test(data)) {
                return false;
            }
        }
        return true;
    }
}
