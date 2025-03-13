package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T>  {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public BaseSchema<T> required() {
        checks.put("required", data -> !Objects.isNull(data));
        return this;
    }

    public boolean isValid(T data) {
        for(var fn : checks.values()) {
            if (!fn.test(data)) {
                return false;
            }
        }
        return true;
    }
}
