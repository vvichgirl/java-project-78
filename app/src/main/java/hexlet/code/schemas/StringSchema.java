package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {
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
}
