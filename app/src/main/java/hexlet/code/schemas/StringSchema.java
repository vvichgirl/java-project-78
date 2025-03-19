package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    @Override
    public final StringSchema required() {
        super.required();
        checks.put("required", data -> !data.isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        checks.put("minLength", data -> data.length() >= length);
        return this;
    }

    public final StringSchema contains(String str) {
        checks.put("contains", data -> data.contains(str));
        return this;
    }
}
