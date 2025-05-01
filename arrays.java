/**
 * How to initialize or declare Arrays using ArrayList
 * Dynamic Array Size
 */
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println(fruits.get(1)); // Output: Banana
        System.out.println(fruits);        // Output: [Apple, Banana, Orange]
    }
}

// --------------------------------------------------------------------------------

/*
List -  Interface representing an ordered collection (like an array, but resizable).
ArrayList - A resizable array implementation of List.
HashMap - A key-value map with no guaranteed order. Very fast for lookup.
LinkedHashMap - A HashMap that remembers insertion order (or access order if configured).
*/

/**
 * How to initialize or declare HashMap Array
 */
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        System.out.println(scores.get("Bob")); // Output: 85
        System.out.println(scores);            // Output: Unordered map
    }
}

// --------------------------------------------------------------------------------
/**
 * How to initialize or declare LinkedHashMap Array
 */
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> user = new LinkedHashMap<>();
        user.put("firstName", "Alice");
        user.put("lastName", "Smith");
        user.put("country", "Canada");

        System.out.println(user); // Output: Maintains insertion order
    }
}
// --------------------------------------------------------------------------------
	•	Use ArrayList when you need a dynamic array.
	•	Use HashMap for fast lookups with no order.
	•	Use LinkedHashMap when order matters (like JSON).
	•	Use List.of(), Map.of(), and streams for modern, concise code.
// --------------------------------------------------------------------------------
    
//  Use List.of(...) and Map.of(...) for immutable collections:
List<String> colors = List.of("Red", "Green", "Blue");
Map<String, Integer> ranks = Map.of("John", 1, "Jane", 2);

// Use forEach with lambdas:
colors.forEach(color -> System.out.println(color));
ranks.forEach((name, rank) -> System.out.println(name + ": " + rank));

// Stream API (for filtering, mapping, etc.):
colors.stream().filter(c -> c.startsWith("R")).forEach(System.out::println);

// --------------------------------------------------------------------------------

// --------------------------------------------------------------------------------

// --------------------------------------------------------------------------------

// --------------------------------------------------------------------------------


// --------------------------------------------------------------------------------
