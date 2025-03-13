package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema sizeof(int size) {
        checks.put("sizeof", data -> data.size() == size);
        return this;
    }
}
