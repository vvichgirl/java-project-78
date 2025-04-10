package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T>  {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean isRequired = false;

    public final void setRequired() {
        isRequired = true;
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
