package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        checks.put("positive", data -> data > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        checks.put("range", data -> data >= min && data <= max);
        return this;
    }
}
