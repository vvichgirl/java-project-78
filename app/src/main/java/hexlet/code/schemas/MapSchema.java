package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        checks.put("required", data -> !Objects.isNull(data));
        return this;
    }

    public MapSchema sizeof(int size) {
        checks.put("sizeof", data -> data.size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        checks.put("shape", data -> {
            for (var schema : schemas.entrySet()) {
                String key = schema.getKey();
                BaseSchema<String> fn = schema.getValue();
                String valueMap = data.get(key);
                if (!fn.isValid(valueMap)) {
                    return false;
                }
            }
            return true;
        });
    }
}
