package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        super.setRequired();
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
