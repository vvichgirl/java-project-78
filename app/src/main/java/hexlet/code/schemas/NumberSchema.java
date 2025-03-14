package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        checks.put("required", data -> !Objects.isNull(data));
        return this;
    }

    public NumberSchema positive() {
        checks.put("positive", data -> Objects.isNull(data) || data > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        checks.put("range", data -> Objects.isNull(data) || data >= min && data <= max);
        return this;
    }
}
