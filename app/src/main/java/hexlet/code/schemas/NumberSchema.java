package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    @Override
    public final NumberSchema required() {
        super.required();
        return this;
    }

    public final NumberSchema positive() {
        checks.put("positive", data -> data > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        checks.put("range", data -> data >= min && data <= max);
        return this;
    }
}
