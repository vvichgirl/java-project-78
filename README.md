### Hexlet tests and linter status:
[![Actions Status](https://github.com/vvichgirl/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/vvichgirl/java-project-78/actions)
[![Java CI](https://github.com/vvichgirl/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/vvichgirl/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/3d7050072ab82a4eedbb/maintainability)](https://codeclimate.com/github/vvichgirl/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/3d7050072ab82a4eedbb/test_coverage)](https://codeclimate.com/github/vvichgirl/java-project-78/test_coverage)
### Description
Data Validator is a library that can be used to check the correctness of data.
#### String validation
##### Methods:
1. required() makes the data mandatory. In other words, it adds a constraint to the schema that does not allow null or empty strings to be used as values. 
2. minLength() adds a minimum length constraint to the schema. The string must be equal to or greater than the specified number. 
3. contains() adds the string content constraint to the schema. The string must contain a specified substring.
##### Example
```
var v = new Validator();
var schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false

var schema1 = v.string();
schema1.minLength(10).minLength(4).isValid("Hexlet");
```
#### Number Validation
##### Methods
1. required() makes the data mandatory. In other words, it adds a constraint to the schema that does not allow null as a value.
2. positive() adds a constraint on the sign of a number. The number must be positive.
3. range() adds a valid range in which the value of the number must fall, including boundaries.
##### Example
```
var v = new Validator();
var schema = v.number();

schema.isValid(5); // true
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10); // true
schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
#### Map Validation
##### Methods
1. required() makes the data mandatory. In other words, it adds a constraint to the schema that does not allow null as a value. 
2. sizeof() adds a constraint on the size of the map. The number of key/value pairs in the Map object must be equal to the specified number.
3. shape() is used to define Map object properties and create a schema to validate their values.
##### Example
```
var v = new Validator();
var schema = v.map();

schema.isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");

schema.sizeof(2);
schema.isValid(human1);  // false

human1.put("lastName", "Smith");

schema.isValid(human1); //true

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schema.shape(schemas);

schema.isValid(human1);

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", "B"); //false
schema.isValid(human2);
```
