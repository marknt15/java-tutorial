// How to print beautifully array of objects OR array with JSON objects inside

// Main.java
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Main {
  record Person(String firstName, String lastName) {}

  public static void main(String[] args) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(gson.toJson(people));
  }
  
}
