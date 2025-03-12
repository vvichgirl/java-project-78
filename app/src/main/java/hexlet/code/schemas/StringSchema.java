package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public class StringSchema {
    private Map<String, Predicate<String>> checks = new LinkedHashMap<>();

    public StringSchema required() {
        checks.put("required", data -> !Objects.isNull(data) && !data.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        checks.put("minLength", data -> data.length() >= length);
        return this;
    }

    public StringSchema contains(String str) {
        checks.put("contains", data -> data.contains(str));
        return this;
    }

    public boolean isValid(String data) {
        AtomicBoolean result = new AtomicBoolean(true);
        checks.forEach((check, fn) -> {
            if (!fn.test(data)) {
                result.set(false);
            }
        });
        return result.get();
    }
}
