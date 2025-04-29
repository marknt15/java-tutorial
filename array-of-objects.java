/**
 * How to print beautifully array of objects OR array with JSON objects 
 * inside using a library called Gson
 */

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
