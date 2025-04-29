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










