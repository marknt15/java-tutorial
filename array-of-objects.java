/**
 * How to print beautifully array of objects OR array with JSON objects 
 * using a library called Gson.
 * It will print with brackets and curly braces including indent
 */

// pom.xml
<dependencies>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20231013</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>

// Main.java
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Main {
    record Person(String firstName, String lastName) {}

    public static void main(String[] args) {
        // Create an array of objects containing first and last names
        Person[] people = {
            new Person("John", "Smith"),
            new Person("Mary", "Johnson"),
        };
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(people));
  }
}

// OUTPUT
[
  {
    "firstName": "John",
    "lastName": "Smith"
  },
  {
    "firstName": "Mary",
    "lastName": "Johnson"
  }
]
// ====================================================================================================

/**
 * How to print beautifully array of objects OR array with JSON objects normally
 * using java.util.Arrays.toString()
 */
public class Main {
    record Person(String firstName, String lastName) {}

    public static void main(String[] args) {
        // Create an array of objects containing first and last names
        Person[] people = {
            new Person("John", "Smith"),
            new Person("Mary", "Johnson"),
        };
        System.out.println(java.util.Arrays.toString(people));
  }
}

// OUTPUT
[{
  "firstName": "John",
  "lastName": "Smith"
}, {
  "firstName": "Mary",
  "lastName": "Johnson"
}]
// ====================================================================================================
/**
 * How to declare or initialize array of objects - Different ways
 */
public class Main {
    // record keyword is shorthand
    record Person(String firstName, String lastName) {}

    // normal way longcut
    class Person {
        private String firstName;
        private String lastName;
        
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
        // Getters and setters (optional, for completeness)
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    

    public static void main(String[] args) {
        // Using Array initializer syntax - most concise for static data.
        // Create, declare or initialize an array of objects containing first and last names
        Person[] people = {
            new Person("John", "Smith"),
            new Person("Mary", "Johnson"),
        };

        // Using new Array with Explicit Size and Loop
        // is useful when you need to initialize elements dynamically or with logic.
        Person[] people = new Person[2];
        people[0] = new Person("John", "Doe");
        people[1] = new Person("Jane", "Smith");

        // Using ArrayList to Initialize (Then Convert to Array)
        // is flexible when the size isn't known upfront.
        import java.util.ArrayList;

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("John", "Doe"));
        personList.add(new Person("Jane", "Smith"));
        Person[] people = personList.toArray(new Person[0]);

        // Using Stream API (Java 8+)
        // modern and functional but might be overkill for simple cases
        import java.util.stream.Stream;
        
        Person[] people = Stream.of(
            new Person("John", "Doe"),
            new Person("Jane", "Smith")
        ).toArray(Person[]::new);


        // Using Arrays.copyOf (When Copying/Expanding Existing Array):
        Person[] initial = { new Person("John", "Doe") };
        Person[] people = Arrays.copyOf(initial, 3);
        people[1] = new Person("Jane", "Smith");
        people[2] = new Person("Bob", "Johnson");
        
        
        System.out.println(java.util.Arrays.toString(people));
  }
}


// ====================================================================================================

/**
 * How to declare or initialize array of objects - second way as JSON with no structure type
 */
import org.json.JSONArray;
import org.json.JSONObject;
public class Main {
    public static void main(String[] args) {
        // Second way to create array of objects
        // Create a JSONObject
        JSONObject person = new JSONObject();
        person.put("firstName", "Bob");
        person.put("lastName", "Johnson");
        person.put("age", 25);

        // Create a JSONArray
        JSONArray hobbies = new JSONArray();
        hobbies.put("painting");
        hobbies.put("swimming");
        person.put("hobbies", hobbies);

        // Create a nested JSONObject
        JSONObject address = new JSONObject();
        address.put("street", "456 Oak Ave");
        address.put("city", "Someville");
        person.put("address", address);

        // Print the structure (using toString(int indentFactor) for pretty printing)
        System.out.println("JSON Structure:");
        System.out.println(person.toString(2)); // The '2' argument indents the output
    }
}

OUTPUT:
JSON Structure:
{
  "firstName": "Bob",
  "lastName": "Johnson",
  "address": {
    "city": "Someville",
    "street": "456 Oak Ave"
  },
  "hobbies": [
    "painting",
    "swimming"
  ],
  "age": 25
}
// ====================================================================================================



